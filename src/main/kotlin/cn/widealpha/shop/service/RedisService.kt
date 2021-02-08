package cn.widealpha.shop.service

import org.springframework.data.redis.core.ValueOperations
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit
import javax.annotation.Resource

@Service
class RedisService {
    @Resource(name = "redisTemplate")
    lateinit var valueOperations: ValueOperations<String, String>

    fun hasKey(key:String): Boolean{
        return valueOperations[key] != null
    }

    fun put(key: String, value: String){
        valueOperations.setIfAbsent(key, value,12,TimeUnit.DAYS)
    }
}