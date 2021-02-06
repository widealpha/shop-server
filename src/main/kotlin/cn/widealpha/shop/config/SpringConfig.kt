package cn.widealpha.shop.config

import cn.widealpha.shop.config.interceptor.TokenInterceptor
import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ImportResource
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootConfiguration
@ImportResource(locations = ["classpath:beans.xml"])
class SpringConfig : WebMvcConfigurer {

    @Bean
    fun redisConnectionFactory(): JedisConnectionFactory {
        val config = RedisStandaloneConfiguration("localhost", 6379)
        return JedisConnectionFactory(config)
    }
}