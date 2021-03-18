package cn.widealpha.shop.service

import cn.widealpha.shop.dao.UserMapper
import cn.widealpha.shop.dao.selectByPrimaryKey
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
    lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    lateinit var userMapper: UserMapper

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(account: String?): UserDetails {
        if (account == null) throw UsernameNotFoundException("账号不能为空")
        val user = userMapper.selectByPrimaryKey(account) ?: throw UsernameNotFoundException("账号不存在")
        return User(account, user.password, AuthorityUtils.commaSeparatedStringToAuthorityList("normal"))
    }
}