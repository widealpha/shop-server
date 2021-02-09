package cn.widealpha.shop.service

import cn.widealpha.shop.dao.*
import cn.widealpha.shop.domain.ChatMessageRecord
import cn.widealpha.shop.entity.ResultEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChatService {
    @Autowired
    lateinit var chatMessageMapper: ChatMessageMapper

    fun sendMessage(chatMessageRecord: ChatMessageRecord): ResultEntity {
        chatMessageRecord.senderAccount = getCurrentAccount()
        val result = chatMessageMapper.insertSelective(chatMessageRecord)
        return ResultEntity.data(result > 0)
    }

    fun unreadMessage(): ResultEntity {
        val list = chatMessageMapper.selectUnreadMessage(getCurrentAccount())
        chatMessageMapper.updateUnreadMessage(getCurrentAccount())
        return ResultEntity.data(list)
    }

    fun lastMessages(limit: Int): ResultEntity {
        return ResultEntity.data(chatMessageMapper.selectMessagesWithLimit(limit, getCurrentAccount()))
    }

    fun targetMessageWithLimit(targetAccount: String, limit: Int): ResultEntity {
        return ResultEntity.data(chatMessageMapper.selectTargetWithLimit(targetAccount, getCurrentAccount(), limit))
    }

    fun allTargetAccounts(): ResultEntity {
        return ResultEntity.data(chatMessageMapper.selectTargetAccounts(getCurrentAccount()))
    }

    fun messageDuringTimeWithTarget(targetAccount: String, startTime: Long, endTime: Long): ResultEntity {
        return ResultEntity.data(
            chatMessageMapper.selectTargetDuringTime(
                targetAccount,
                getCurrentAccount(),
                Date(startTime),
                Date(endTime)
            )
        )
    }

    private fun getCurrentAccount(): String {
        return SecurityContextHolder.getContext().authentication.name
    }
}