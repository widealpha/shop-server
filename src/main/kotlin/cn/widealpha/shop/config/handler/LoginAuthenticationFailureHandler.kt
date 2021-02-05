package cn.widealpha.shop.config.handler

import cn.widealpha.shop.entity.ResultEntity
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class LoginAuthenticationFailureHandler : AuthenticationFailureHandler {
    override fun onAuthenticationFailure(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        exception: AuthenticationException?
    ) {
        response?.characterEncoding = "UTF-8"
        response?.setHeader("Content-type", "text/html;charset=UTF-8");
        when (exception) {
            is UsernameNotFoundException -> {
                response?.writer?.print(ResultEntity.error(-4, "用户名不存在"))
            }
            is BadCredentialsException -> {
                response?.writer?.print(ResultEntity.error(-5, "用户名或密码错误"))
            }
            else -> {
                response?.writer?.print(ResultEntity.error(-6, "登陆状态错误"))
            }
        }
    }
}