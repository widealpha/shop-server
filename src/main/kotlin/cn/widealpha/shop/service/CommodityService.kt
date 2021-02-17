package cn.widealpha.shop.service

import cn.widealpha.shop.dao.*
import cn.widealpha.shop.domain.CommodityRecord
import cn.widealpha.shop.entity.ResultEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class CommodityService {
    @Autowired
    lateinit var commodityMapper: CommodityMapper

    fun addCommodity(commodityRecord: CommodityRecord): ResultEntity {
        commodityRecord.account = getCurrentAccount()
        val result = commodityMapper.insertSelective(
            commodityRecord
        )
        return ResultEntity.data(result > 0)
    }

    fun allCommodity(): ResultEntity {
        val result = commodityMapper.selectAll()
        return ResultEntity.data(result)
    }

    fun searchCommodity(key: String): ResultEntity {
        val result = commodityMapper.selectByKey(key)
        return ResultEntity.data(result)
    }

    fun commodityInfo(commodityId: Int): ResultEntity {
        val result = commodityMapper.selectByPrimaryKey(commodityId)
            ?: return ResultEntity.error(-1, "商品不存在")
        return ResultEntity.data(result)
    }

    fun myCommodity(): ResultEntity {
        val result = commodityMapper.selectMyAll(getCurrentAccount())
        return ResultEntity.data(result)
    }

    fun deleteCommodity(commodityId: Int):ResultEntity {
        val commodityRecord = commodityMapper.selectByPrimaryKey(commodityId);
        return if (commodityRecord?.account == getCurrentAccount()){
            ResultEntity.data(commodityMapper.deleteByPrimaryKey(commodityId) >0)
        } else {
            ResultEntity.error(-1, "商品不存在，或无权删除商品")
        }
    }

    private fun getCurrentAccount(): String {
        return SecurityContextHolder.getContext().authentication.name
    }
}