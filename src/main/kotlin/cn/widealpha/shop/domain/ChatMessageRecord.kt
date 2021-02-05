/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-02-05T01:47:03.1116241+08:00
 */
package cn.widealpha.shop.domain

import java.util.Date

data class ChatMessageRecord(
    var messageId: Int? = null,
    var senderAccount: String? = null,
    var targetAccount: String? = null,
    var timestamp: Date? = null,
    var message: String? = null,
    var readTimes: Int? = null
)