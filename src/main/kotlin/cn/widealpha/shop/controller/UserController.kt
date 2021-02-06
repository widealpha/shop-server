package cn.widealpha.shop.controller

import cn.widealpha.shop.entity.ResultEntity
import cn.widealpha.shop.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
class UserController {
    @Autowired
    lateinit var userService: UserService

    @PostMapping("/register")
    fun register(account: String, password: String, username: String?): ResultEntity {
        return userService.register(account, password, username)
    }

    @PostMapping("/login")
    fun login(account: String, password: String): ResultEntity {
        return userService.login(account, password)
    }

    @PostMapping("/changePassword")
    fun changePassword(password: String, newPassword: String): ResultEntity {
        return userService.changePassword(password, newPassword)
    }

    @PostMapping("/changeUsername")
    fun changeUsername(newUsername: String): ResultEntity {
        return userService.changeUsername(newUsername)
    }

    @PostMapping("/username")
    fun getUsername(): ResultEntity {
        return userService.getUsername()
    }
}