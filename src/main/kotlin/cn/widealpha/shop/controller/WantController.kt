package cn.widealpha.shop.controller

import cn.widealpha.shop.domain.WantRecord
import cn.widealpha.shop.entity.ResultEntity
import cn.widealpha.shop.service.WantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/want")
class WantController {
    @Autowired
    lateinit var wantService: WantService

    @RequestMapping("/addWant")
    fun addWant(
        title: String? = null,
        description: String? = null
    ): ResultEntity {
        val wantRecord = WantRecord(null,null, title, description)
        return wantService.addWant(wantRecord)
    }

    @RequestMapping("/want")
    fun getWant(wantId: Int): ResultEntity {
        return wantService.wantInfo(wantId)
    }

    @RequestMapping("/allWant")
    fun allWant(): ResultEntity {
        return wantService.allWant()
    }

    @RequestMapping("/myWant")
    fun myWant(): ResultEntity {
        return wantService.myWant()
    }

    @RequestMapping("/searchWant")
    fun searchWant(key: String): ResultEntity {
        return wantService.searchWant(key)
    }
}