/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-02-05T01:47:03.1116241+08:00
 */
package cn.widealpha.shop.dao

import cn.widealpha.shop.dao.ChatMessageDynamicSqlSupport.ChatMessage
import cn.widealpha.shop.dao.ChatMessageDynamicSqlSupport.ChatMessage.message
import cn.widealpha.shop.dao.ChatMessageDynamicSqlSupport.ChatMessage.messageId
import cn.widealpha.shop.dao.ChatMessageDynamicSqlSupport.ChatMessage.readTimes
import cn.widealpha.shop.dao.ChatMessageDynamicSqlSupport.ChatMessage.senderAccount
import cn.widealpha.shop.dao.ChatMessageDynamicSqlSupport.ChatMessage.targetAccount
import cn.widealpha.shop.dao.ChatMessageDynamicSqlSupport.ChatMessage.timestamp
import cn.widealpha.shop.domain.ChatMessageRecord
import org.mybatis.dynamic.sql.SqlBuilder
import org.mybatis.dynamic.sql.SqlBuilder.*
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*
import java.util.*

fun ChatMessageMapper.count(completer: CountCompleter) =
    countFrom(this::count, ChatMessage, completer)

fun ChatMessageMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, ChatMessage, completer)

fun ChatMessageMapper.deleteByPrimaryKey(messageId_: Int) =
    delete {
        where(messageId, isEqualTo(messageId_))
    }

fun ChatMessageMapper.insert(record: ChatMessageRecord) =
    insert(this::insert, record, ChatMessage) {
        map(messageId).toProperty("messageId")
        map(senderAccount).toProperty("senderAccount")
        map(targetAccount).toProperty("targetAccount")
        map(timestamp).toProperty("timestamp")
        map(message).toProperty("message")
        map(readTimes).toProperty("readTimes")
    }

fun ChatMessageMapper.insertMultiple(records: Collection<ChatMessageRecord>) =
    insertMultiple(this::insertMultiple, records, ChatMessage) {
        map(messageId).toProperty("messageId")
        map(senderAccount).toProperty("senderAccount")
        map(targetAccount).toProperty("targetAccount")
        map(timestamp).toProperty("timestamp")
        map(message).toProperty("message")
        map(readTimes).toProperty("readTimes")
    }

fun ChatMessageMapper.insertMultiple(vararg records: ChatMessageRecord) =
    insertMultiple(records.toList())

fun ChatMessageMapper.insertSelective(record: ChatMessageRecord) =
    insert(this::insert, record, ChatMessage) {
        map(messageId).toPropertyWhenPresent("messageId", record::messageId)
        map(senderAccount).toPropertyWhenPresent("senderAccount", record::senderAccount)
        map(targetAccount).toPropertyWhenPresent("targetAccount", record::targetAccount)
        map(timestamp).toPropertyWhenPresent("timestamp", record::timestamp)
        map(message).toPropertyWhenPresent("message", record::message)
        map(readTimes).toPropertyWhenPresent("readTimes", record::readTimes)
    }

private val columnList = listOf(messageId, senderAccount, targetAccount, timestamp, message, readTimes)

fun ChatMessageMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, ChatMessage, completer)

fun ChatMessageMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, ChatMessage, completer)

fun ChatMessageMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, ChatMessage, completer)

fun ChatMessageMapper.selectTargetAccounts(account_: String) =
    selectDistinct(this::selectManyAccount, listOf(senderAccount, targetAccount), ChatMessage) {
        where(senderAccount, isEqualTo(account_))
    }

fun ChatMessageMapper.selectByPrimaryKey(messageId_: Int) =
    selectOne {
        where(messageId, isEqualTo(messageId_))
    }

fun ChatMessageMapper.selectUnreadMessage(account_: String) =
    selectOne {
        where(targetAccount, isEqualTo(account_))
        and(readTimes, isEqualTo(0))
        orderBy(timestamp.descending())
    }

fun ChatMessageMapper.selectMessagesWithLimit(limit_: Int, account_: String) =
    select {
        where(senderAccount, isEqualTo(account_))
        or(targetAccount, isEqualTo(account_))
        orderBy(timestamp.descending())
        limit(limit_.toLong())
    }

fun ChatMessageMapper.selectTargetWithLimit(targetAccount_: String, account_: String, limit_: Int) =
    select {
        where(senderAccount, isEqualTo(account_)) {
            and(targetAccount, isEqualTo(targetAccount_))
        }
        or(senderAccount, isEqualTo(targetAccount_)) {
            and(targetAccount, isEqualTo(account_))
        }
        orderBy(timestamp.descending())
        limit(limit_.toLong())
    }

fun ChatMessageMapper.selectTargetDuringTime(
    targetAccount_: String,
    account_: String,
    startTimestamp: Date,
    endTimestamp: Date
) =
    select {
        where(senderAccount, isEqualTo(account_)) {
            and(targetAccount, isEqualTo(targetAccount_))
            and(timestamp, isBetween(startTimestamp).and(endTimestamp))
        }
        or(senderAccount, isEqualTo(targetAccount_)) {
            and(targetAccount, isEqualTo(account_))
            and(timestamp, isBetween(startTimestamp).and(endTimestamp))
        }
    }

fun ChatMessageMapper.update(completer: UpdateCompleter) =
    update(this::update, ChatMessage, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: ChatMessageRecord) =
    apply {
        set(messageId).equalTo(record::messageId)
        set(senderAccount).equalTo(record::senderAccount)
        set(targetAccount).equalTo(record::targetAccount)
        set(timestamp).equalTo(record::timestamp)
        set(message).equalTo(record::message)
        set(readTimes).equalTo(record::readTimes)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: ChatMessageRecord) =
    apply {
        set(messageId).equalToWhenPresent(record::messageId)
        set(senderAccount).equalToWhenPresent(record::senderAccount)
        set(targetAccount).equalToWhenPresent(record::targetAccount)
        set(timestamp).equalToWhenPresent(record::timestamp)
        set(message).equalToWhenPresent(record::message)
        set(readTimes).equalToWhenPresent(record::readTimes)
    }

fun ChatMessageMapper.updateByPrimaryKey(record: ChatMessageRecord) =
    update {
        set(senderAccount).equalTo(record::senderAccount)
        set(targetAccount).equalTo(record::targetAccount)
        set(timestamp).equalTo(record::timestamp)
        set(message).equalTo(record::message)
        set(readTimes).equalTo(record::readTimes)
        where(messageId, isEqualTo(record::messageId))
    }

fun ChatMessageMapper.updateByPrimaryKeySelective(record: ChatMessageRecord) =
    update {
        set(senderAccount).equalToWhenPresent(record::senderAccount)
        set(targetAccount).equalToWhenPresent(record::targetAccount)
        set(timestamp).equalToWhenPresent(record::timestamp)
        set(message).equalToWhenPresent(record::message)
        set(readTimes).equalToWhenPresent(record::readTimes)
        where(messageId, isEqualTo(record::messageId))
    }

fun ChatMessageMapper.updateUnreadMessage(targetAccount_: String) =
    update {
        set(readTimes).equalTo(1)
        where(readTimes, isEqualTo(0))
        and(targetAccount, isEqualTo(targetAccount_))
    }