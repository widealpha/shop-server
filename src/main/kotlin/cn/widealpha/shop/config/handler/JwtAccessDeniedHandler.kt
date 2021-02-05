package cn.widealpha.shop.config.handler

import cn.widealpha.shop.entity.ResultEntity
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAccessDeniedHandler:AccessDeniedHandler {
    override fun handle(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        exception: AccessDeniedException?
    ) {
        response?.characterEncoding = "UTF-8"
        response?.setHeader("Content-type", "text/html;charset=UTF-8");
        response?.writer?.print(ResultEntity.error(-7, "无权访问"))
    }
}