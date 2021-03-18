package cn.widealpha.shop.controller

import cn.widealpha.shop.domain.CommodityRecord
import cn.widealpha.shop.entity.ResultEntity
import cn.widealpha.shop.service.CommodityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/commodity")
class CommodityController {
    @Autowired
    lateinit var commodityService: CommodityService

    @RequestMapping("/addCommodity")
    fun addCommodity(
            title: String? = null,
            description: String? = null,
            price: Double? = null,
            category: String? = null,
            image: String? = null
    ): ResultEntity {
        val commodityRecord = CommodityRecord(null, title, description, price, category, image)
        return commodityService.addCommodity(commodityRecord)
    }

    @RequestMapping("/commodity")
    fun getCommodity(commodityId: Int): ResultEntity {
        return commodityService.commodityInfo(commodityId)
    }

    @RequestMapping("/allCommodity")
    fun allCommodity(): ResultEntity {
        return commodityService.allCommodity()
    }

    @RequestMapping("/myCommodity")
    fun myCommodity(): ResultEntity {
        return commodityService.myCommodity()
    }

    @RequestMapping("/deleteMyCommodity")
    fun deleteMyCommodity(commodityId: Int): ResultEntity {
        return commodityService.deleteCommodity(commodityId)
    }

    @RequestMapping("/searchCommodity")
    fun searchCommodity(key: String): ResultEntity {
        return commodityService.searchCommodity(key)
    }
}