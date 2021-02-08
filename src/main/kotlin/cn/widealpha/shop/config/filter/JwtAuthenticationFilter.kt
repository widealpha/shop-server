package cn.widealpha.shop.config.filter

import cn.widealpha.shop.entity.ResultEntity
import cn.widealpha.shop.service.RedisService
import cn.widealpha.shop.util.JwtTokenUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.stereotype.Component
import java.io.IOException
import java.lang.Exception
import javax.annotation.Resource
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationFilter(authenticationManager: AuthenticationManager?) :
    BasicAuthenticationFilter(authenticationManager) {
    @Autowired
    lateinit var redisService: RedisService

    @Throws(IOException::class, ServletException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val tokenHeader = request.getHeader(JwtTokenUtil.TOKEN_HEADER)
        //如果请求头中没有Authorization信息则直接放行了
        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            chain.doFilter(request, response)
            return
        }
        //如果请求头中有token,则进行解析，并且设置认证信息
        try {
            if (!JwtTokenUtil.isExpiration(tokenHeader.replace(JwtTokenUtil.TOKEN_PREFIX, ""))!!) {
                if (redisService.hasKey(tokenHeader)) {
                    response.apply {
                        characterEncoding = "UTF-8"
                        setHeader("Content-type", "text/html;charset=UTF-8")
                        writer.print(ResultEntity.error(-10, "Token已注销"))
                    }
                    return
                }
                //设置上下文
                val authentication = getAuthentication(tokenHeader)
                SecurityContextHolder.getContext().authentication = authentication
            }
        } catch (ignore: Exception) {
            response.apply {
                characterEncoding = "UTF-8"
                setHeader("Content-type", "text/html;charset=UTF-8")
                writer.print(ResultEntity.error(-8, "Token无效"))
            }
            return
        }
        super.doFilterInternal(request, response, chain)
    }

    //获取用户信息
    private fun getAuthentication(tokenHeader: String): UsernamePasswordAuthenticationToken? {
        val token: String = tokenHeader.replace(JwtTokenUtil.TOKEN_PREFIX, "")
        val username: String? = JwtTokenUtil.getUserName(token)
        // 获得权限 添加到权限上去
        val role: String = JwtTokenUtil.getUserRole(token)
        val roles: MutableList<GrantedAuthority> = ArrayList()
        roles.add(GrantedAuthority { role })
        return if (username != null) {
            UsernamePasswordAuthenticationToken(username, null, roles)
        } else null
    }
}