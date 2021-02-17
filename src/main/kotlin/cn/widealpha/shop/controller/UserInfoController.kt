package cn.widealpha.shop.controller

import cn.widealpha.shop.domain.UserInfoRecord
import cn.widealpha.shop.entity.ResultEntity
import cn.widealpha.shop.service.UserInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/user")
class UserInfoController {
    @Autowired
    lateinit var userInfoService: UserInfoService

    @PostMapping("userInfo")
    fun getUserInfo(): ResultEntity {
        return userInfoService.gerUserInfo()
    }

    @PostMapping("changeHeadImage")
    fun changeHeadImage(@RequestParam image: MultipartFile?): ResultEntity {
        return userInfoService.setHeadImage(image)
    }

    @PostMapping("headImage")
    fun getHeadImage(): ResultEntity {
        return userInfoService.getHeadImage()
    }

    @PostMapping("othersHeadImage")
    fun getOthersHeadImage(account: String): ResultEntity {
        return userInfoService.getOthersHeadImage(account)
    }

    @PostMapping("changeUserInfo")
    fun changeUserInfo(
        headImage: String? = null,
        age: Int? = null,
        location: String? = null,
        introduction: String? = null,
        sex: Int? = null,
        name: String? = null
    ): ResultEntity {
        val userInfoRecord = UserInfoRecord(null, headImage, age, location, introduction, sex, name)
        return userInfoService.setUserInfo(userInfoRecord)
    }
}