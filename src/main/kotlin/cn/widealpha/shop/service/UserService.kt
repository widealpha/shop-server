package cn.widealpha.shop.service

import cn.widealpha.shop.dao.*
import cn.widealpha.shop.domain.UserInfoRecord
import cn.widealpha.shop.domain.UserRecord
import cn.widealpha.shop.entity.ResultEntity
import cn.widealpha.shop.util.JwtTokenUtil
import cn.widealpha.shop.util.StringUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.TimeUnit
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

@Service
class UserService {
    @Autowired
    lateinit var userMapper: UserMapper

    @Autowired
    lateinit var userInfoMapper: UserInfoMapper

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    @Autowired
    lateinit var redisService: RedisService

    @Autowired
    lateinit var request: HttpServletRequest

    fun register(account: String, password: String, username: String?): ResultEntity {
        if (StringUtil.isEmpty(account, password)) {
            return ResultEntity.data("用户名或密码不能为空")
        }
        var name = username
        if (name == null)
            name = UUID.randomUUID().toString().substring(0, 6)
        return try {
            val result = userMapper.insert(
                UserRecord(
                    account = account,
                    username = name,
                    password = passwordEncoder.encode(password)
                )
            )
            userInfoMapper.insertSelective(
                UserInfoRecord(
                    account = account
                )
            )
            ResultEntity.data(result > 0)
        } catch (exception: DuplicateKeyException) {
            ResultEntity.error(-1, "用户名已存在")
        }
    }

    fun login(account: String, password: String): ResultEntity {
        val token = UsernamePasswordAuthenticationToken(
            account,
            password,
            AuthorityUtils.commaSeparatedStringToAuthorityList("normal")
        )
        val auth = authenticationManager.authenticate(token)
        SecurityContextHolder.getContext().authentication = auth
        return ResultEntity.data(JwtTokenUtil.createToken(account, "normal"))
    }

    fun logout(): ResultEntity {
        redisService.put(request.getHeader(JwtTokenUtil.TOKEN_HEADER), "0")
        return ResultEntity.data(true)
    }

    fun changePassword(password: String, newPassword: String): ResultEntity {
        val userRecord = userMapper.selectByPrimaryKey(getCurrentAccount()) ?: return ResultEntity.error(-1, "用户不存在")
        return if (passwordEncoder.matches(password, userRecord.password)) {
            userRecord.password = passwordEncoder.encode(newPassword)
            val result = userMapper.updateByPrimaryKeySelective(userRecord)
            ResultEntity.data(result > 0)
        } else {
            ResultEntity.error(-2, "原密码密码错误")
        }
    }

    fun changeUsername(newUsername: String): ResultEntity {
        val userRecord = userMapper.selectByPrimaryKey(getCurrentAccount()) ?: return ResultEntity.error(-1, "用户不存在")
        userRecord.username = newUsername
        val result = userMapper.updateByPrimaryKeySelective(userRecord)
        return ResultEntity.data(result > 0)
    }

    fun getUsername(): ResultEntity {
        val userRecord = userMapper.selectByPrimaryKey(getCurrentAccount()) ?: return ResultEntity.error(-1, "用户不存在")
        return ResultEntity.data(userRecord.username)
    }

    fun getOthersUsername(account: String): ResultEntity {
        val userRecord = userMapper.selectByPrimaryKey(account) ?: return ResultEntity.error(-1, "用户不存在")
        return ResultEntity.data(userRecord.username)
    }

    private fun getCurrentAccount(): String {
        return SecurityContextHolder.getContext().authentication.name
    }
}