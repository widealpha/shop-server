package cn.widealpha.shop.config

import cn.widealpha.shop.config.filter.JwtAuthenticationFilter
import cn.widealpha.shop.config.handler.GlobalAccessDeniedHandler
import cn.widealpha.shop.config.handler.GlobalAuthenticationEntryPoint
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        //授权
        http.authorizeRequests()
            .antMatchers("/login", "/user/login", "/user/register", "/user/logout").permitAll()
            .anyRequest().authenticated()
            .and().addFilterBefore(
                getJwtAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter::class.java
            )
            .exceptionHandling()
            .accessDeniedHandler(GlobalAccessDeniedHandler())
            .authenticationEntryPoint(GlobalAuthenticationEntryPoint())
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http.csrf().disable()
    }

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Bean
    fun getPw(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun getJwtAuthenticationFilter() :JwtAuthenticationFilter{
        return JwtAuthenticationFilter(authenticationManager())
    }
}