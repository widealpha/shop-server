package cn.widealpha.shop.service

import cn.widealpha.shop.dao.UserInfoMapper
import cn.widealpha.shop.dao.selectByPrimaryKey
import cn.widealpha.shop.dao.updateByPrimaryKey
import cn.widealpha.shop.domain.UserInfoRecord
import cn.widealpha.shop.entity.ResultEntity
import cn.widealpha.shop.util.FileUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class UserInfoService {
    @Autowired
    lateinit var userInfoMapper: UserInfoMapper

    fun setHeadImage(multipartFile: MultipartFile?): ResultEntity {
        val link = FileUtil.saveImage(multipartFile, "/image")
        val userInfoRecord = userInfoMapper.selectByPrimaryKey(getCurrentAccount())
            ?: return ResultEntity.error(-1, "用户不存在")
        userInfoRecord.headImage = link
        val result = userInfoMapper.updateByPrimaryKey(userInfoRecord)
        return ResultEntity.data(result > 0)
    }

    fun gerUserInfo(): ResultEntity {
        val userInfoRecord = userInfoMapper.selectByPrimaryKey(getCurrentAccount())
            ?: return ResultEntity.error(-1, "用户不存在")
        return ResultEntity.data(userInfoRecord)
    }

    fun getHeadImage(): ResultEntity {
        val userInfoRecord = userInfoMapper.selectByPrimaryKey(getCurrentAccount())
            ?: return ResultEntity.error(-1, "用户不存在")
        return ResultEntity.data(userInfoRecord.headImage)
    }

    fun getOthersHeadImage(account: String): ResultEntity {
        val userInfoRecord = userInfoMapper.selectByPrimaryKey(account)
            ?: return ResultEntity.error(-1, "用户不存在")
        return ResultEntity.data(userInfoRecord.headImage)
    }

    fun setUserInfo(userInfo: UserInfoRecord): ResultEntity {
        val userInfoRecord = userInfoMapper.selectByPrimaryKey(getCurrentAccount())
            ?: return ResultEntity.error(-1, "用户不存在")
        if (userInfo.age != null) userInfoRecord.age = userInfo.age
        if (userInfo.introduction != null) userInfoRecord.introduction = userInfo.introduction
        if (userInfo.location != null) userInfoRecord.location = userInfo.location
        if (userInfo.sex != null) userInfoRecord.sex = userInfo.sex
        if (userInfo.name != null) userInfoRecord.name = userInfo.name
        val result = userInfoMapper.updateByPrimaryKey(userInfoRecord)
        return ResultEntity.data(result > 0)
    }

    private fun getCurrentAccount(): String {
        return SecurityContextHolder.getContext().authentication.name
    }
}