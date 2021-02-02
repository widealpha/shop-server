package cn.widealpha.shop.domain

import java.sql.Timestamp

data class Message(
    var messageId: Int,
    var senderId: Int,
    var targetId: Int,
    var message: String,
    var readTimes: Int,
    var timestamp: Timestamp
)