package cn.widealpha.shop.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserDetailService : UserDetailsService {
    @Autowired
    lateinit var passwordEncoder: PasswordEncoder;

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails {
        if (username == null) throw UsernameNotFoundException("用户名不存在")
        val password = passwordEncoder.encode("1234")
        return User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("normal"))
    }
}