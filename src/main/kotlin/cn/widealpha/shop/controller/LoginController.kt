package cn.widealpha.shop.controller

import cn.widealpha.shop.model.Result
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController {
    @RequestMapping("/login")
    fun login(): Result{
        return Result.data("")
    }
}