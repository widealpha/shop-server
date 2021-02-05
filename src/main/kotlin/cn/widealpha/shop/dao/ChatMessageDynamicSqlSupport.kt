/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-02-05T01:47:03.1116241+08:00
 */
package cn.widealpha.shop.dao

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object ChatMessageDynamicSqlSupport {
    object ChatMessage : SqlTable("chat_message") {
        val messageId = column<Int>("message_id", JDBCType.INTEGER)

        val senderAccount = column<String>("sender_account", JDBCType.VARCHAR)

        val targetAccount = column<String>("target_account", JDBCType.VARCHAR)

        val timestamp = column<Date>("timestamp", JDBCType.TIMESTAMP)

        val message = column<String>("message", JDBCType.VARCHAR)

        val readTimes = column<Int>("read_times", JDBCType.INTEGER)
    }
}