package cn.widealpha.shop.controller

import cn.widealpha.shop.domain.ChatMessageRecord
import cn.widealpha.shop.entity.ResultEntity
import cn.widealpha.shop.service.ChatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("chat")
class ChatController {
    @Autowired
    lateinit var chatService: ChatService

    @RequestMapping("sendMessage")
    fun sendMessage(targetAccount: String, message: String): ResultEntity {
        val chatMessageRecord =
                ChatMessageRecord(targetAccount = targetAccount, message = message, timestamp = Date())
        return chatService.sendMessage(chatMessageRecord)
    }

    @RequestMapping("unreadMessage")
    fun unreadMessage(): ResultEntity {
        return chatService.unreadMessage()
    }

    @RequestMapping("lastMessages")
    fun lastMessage(limit: Int): ResultEntity {
        return chatService.lastMessages(limit)
    }

    @RequestMapping("allTargetAccounts")
    fun allTargets(): ResultEntity {
        return chatService.allTargetAccounts()
    }

    @RequestMapping("messagesWithTarget")
    fun targetMessageWithLimit(targetAccount: String, limit: Int): ResultEntity {
        return chatService.targetMessageWithLimit(targetAccount, limit)
    }

    @RequestMapping("messageDuringWithTarget")
    fun messageDuringTimeWithTarget(targetAccount: String, startTime: Long, endTime: Long): ResultEntity {
        return chatService.messageDuringTimeWithTarget(targetAccount, startTime, endTime)
    }
}