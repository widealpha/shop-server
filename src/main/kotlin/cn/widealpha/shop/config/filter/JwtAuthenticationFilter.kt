package cn.widealpha.shop.config.filter

import cn.widealpha.shop.util.JwtTokenUtil
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationFilter(authenticationManager: AuthenticationManager?) :
    BasicAuthenticationFilter(authenticationManager) {
    @Throws(IOException::class, ServletException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val tokenHeader = request.getHeader(JwtTokenUtil.TOKEN_HEADER)
        //如果请求头中没有Authorization信息则直接放行了
        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            chain.doFilter(request, response)
            return
        }
        //如果请求头中有token,则进行解析，并且设置认证信息
        if (!JwtTokenUtil.isExpiration(tokenHeader.replace(JwtTokenUtil.TOKEN_PREFIX, ""))!!) {
            //设置上下文
            val authentication = getAuthentication(tokenHeader)
            SecurityContextHolder.getContext().authentication = authentication
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