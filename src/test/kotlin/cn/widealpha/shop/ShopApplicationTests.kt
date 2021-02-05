package cn.widealpha.shop

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootTest
class ShopApplicationTests {

    @Test
    fun contextLoads() {
        val passwordEncoder = BCryptPasswordEncoder()
        val code = passwordEncoder.encode("kmh")
        println(passwordEncoder.encode("kmh"))
        println(passwordEncoder.matches("kmh", code))
    }

}
