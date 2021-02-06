package cn.widealpha.shop.config.handler

import cn.widealpha.shop.entity.ResultEntity
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.InsufficientAuthenticationException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.AuthenticationEntryPoint
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class GlobalAuthenticationEntryPoint :AuthenticationEntryPoint{
    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        response?.apply {
            characterEncoding = "UTF-8"
            setHeader("Content-type", "text/html;charset=UTF-8");
            when (authException) {
                is UsernameNotFoundException -> {
                    writer.print(ResultEntity.error(-4, "用户名不存在"))
                }
                is BadCredentialsException -> {
                    writer.print(ResultEntity.error(-5, "用户名或密码错误"))
                }
                is InsufficientAuthenticationException ->{
                    writer.print(ResultEntity.error(-8, "Token无效"))
                }
                else -> {
                    writer.print(ResultEntity.error(-6, "登陆状态错误"))
                }
            }
        }
    }
}