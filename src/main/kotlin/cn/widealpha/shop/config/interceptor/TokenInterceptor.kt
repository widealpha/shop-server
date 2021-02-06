package cn.widealpha.shop.config.interceptor

import cn.widealpha.shop.entity.ResultEntity
import cn.widealpha.shop.util.JwtTokenUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.stereotype.Component
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class TokenInterceptor : HandlerInterceptorAdapter() {
    @Resource(name = "redisTemplate")
    lateinit var valueOperations: ValueOperations<String, String>

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (valueOperations.get(request.getHeader(JwtTokenUtil.TOKEN_HEADER)) != null) {
            response.apply {
                characterEncoding = "UTF-8"
                setHeader("Content-type", "text/html;charset=UTF-8");
                writer.print(ResultEntity.error(-9, "token状态异常"))
            }
            return false
        }
        return true
    }
}