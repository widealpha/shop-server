/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-02-05T01:47:03.1116241+08:00
 */
package cn.widealpha.shop.dao

import cn.widealpha.shop.domain.ChatMessageRecord
import org.apache.ibatis.annotations.DeleteProvider
import org.apache.ibatis.annotations.InsertProvider
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.annotations.UpdateProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

@Mapper
interface ChatMessageMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    fun count(selectStatement: SelectStatementProvider): Long

    @DeleteProvider(type=SqlProviderAdapter::class, method="delete")
    fun delete(deleteStatement: DeleteStatementProvider): Int

    @InsertProvider(type=SqlProviderAdapter::class, method="insert")
    fun insert(insertStatement: InsertStatementProvider<ChatMessageRecord>): Int

    @InsertProvider(type=SqlProviderAdapter::class, method="insertMultiple")
    fun insertMultiple(multipleInsertStatement: MultiRowInsertStatementProvider<ChatMessageRecord>): Int

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("ChatMessageRecordResult")
    fun selectOne(selectStatement: SelectStatementProvider): ChatMessageRecord?

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="ChatMessageRecordResult", value = [
        Result(column="message_id", property="messageId", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="sender_account", property="senderAccount", jdbcType=JdbcType.VARCHAR),
        Result(column="target_account", property="targetAccount", jdbcType=JdbcType.VARCHAR),
        Result(column="timestamp", property="timestamp", jdbcType=JdbcType.TIMESTAMP),
        Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        Result(column="read_times", property="readTimes", jdbcType=JdbcType.INTEGER)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<ChatMessageRecord>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="ChatMessageTargetAccountResult", value = [
        Result(column="target_account", property="targetAccount", jdbcType=JdbcType.VARCHAR)
    ])
    fun selectManyAccount(selectStatement: SelectStatementProvider): List<String>

    @UpdateProvider(type=SqlProviderAdapter::class, method="update")
    fun update(updateStatement: UpdateStatementProvider): Int
}