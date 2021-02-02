package cn.widealpha.shop.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.formLogin().loginPage("/login")
        //授权
        http.authorizeRequests()
            .antMatchers("/login").permitAll()
            .anyRequest().authenticated()

        http.csrf().disable()
    }

    @Bean
    fun getPw(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}