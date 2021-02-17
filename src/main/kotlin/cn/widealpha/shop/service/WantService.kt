package cn.widealpha.shop.service

import cn.widealpha.shop.dao.*
import cn.widealpha.shop.domain.WantRecord
import cn.widealpha.shop.entity.ResultEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class WantService {
    @Autowired
    lateinit var wantMapper: WantMapper

    fun addWant(wantRecord: WantRecord): ResultEntity {
        wantRecord.account = getCurrentAccount()
        val result = wantMapper.insertSelective(
            wantRecord
        )
        return ResultEntity.data(result > 0)
    }

    fun allWant(): ResultEntity {
        val result = wantMapper.selectAll()
        return ResultEntity.data(result)
    }

    fun searchWant(key: String): ResultEntity {
        val result = wantMapper.selectByKey(key)
        return ResultEntity.data(result)
    }

    fun wantInfo(wantId: Int): ResultEntity {
        val result = wantMapper.selectByPrimaryKey(wantId)
            ?: return ResultEntity.error(-1, "需求不存在")
        return ResultEntity.data(result)
    }

    fun myWant(): ResultEntity {
        val result = wantMapper.selectMyAll(getCurrentAccount())
        return ResultEntity.data(result)
    }

    fun deleteWant(wantId: Int):ResultEntity{
        val wantRecord = wantMapper.selectByPrimaryKey(wantId)
        return if (wantRecord?.account == getCurrentAccount()){
            ResultEntity.data(wantMapper.deleteByPrimaryKey(wantId) > 0)
        } else {
            ResultEntity.error(-1, "需求不存在，或无权删除需求")
        }
    }

    private fun getCurrentAccount(): String {
        return SecurityContextHolder.getContext().authentication.name
    }
}