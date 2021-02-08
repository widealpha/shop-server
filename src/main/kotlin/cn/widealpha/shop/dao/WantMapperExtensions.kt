/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-02-07T03:06:50.602+08:00
 */
package cn.widealpha.shop.dao

import cn.widealpha.shop.dao.WantDynamicSqlSupport.Want
import cn.widealpha.shop.dao.WantDynamicSqlSupport.Want.account
import cn.widealpha.shop.dao.WantDynamicSqlSupport.Want.description
import cn.widealpha.shop.dao.WantDynamicSqlSupport.Want.title
import cn.widealpha.shop.dao.WantDynamicSqlSupport.Want.wantId
import cn.widealpha.shop.domain.WantRecord
import org.mybatis.dynamic.sql.SqlBuilder
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun WantMapper.count(completer: CountCompleter) =
    countFrom(this::count, Want, completer)

fun WantMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Want, completer)

fun WantMapper.deleteByPrimaryKey(wantId_: Int) =
    delete {
        where(wantId, isEqualTo(wantId_))
    }

fun WantMapper.insert(record: WantRecord) =
    insert(this::insert, record, Want) {
        map(wantId).toProperty("wantId")
        map(account).toProperty("account")
        map(title).toProperty("title")
        map(description).toProperty("description")
    }

fun WantMapper.insertMultiple(records: Collection<WantRecord>) =
    insertMultiple(this::insertMultiple, records, Want) {
        map(wantId).toProperty("wantId")
        map(account).toProperty("account")
        map(title).toProperty("title")
        map(description).toProperty("description")
    }

fun WantMapper.insertMultiple(vararg records: WantRecord) =
    insertMultiple(records.toList())

fun WantMapper.insertSelective(record: WantRecord) =
    insert(this::insert, record, Want) {
        map(wantId).toPropertyWhenPresent("wantId", record::wantId)
        map(account).toPropertyWhenPresent("account", record::account)
        map(title).toPropertyWhenPresent("title", record::title)
        map(description).toPropertyWhenPresent("description", record::description)
    }

private val columnList = listOf(wantId, account, title, description)

fun WantMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Want, completer)

fun WantMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Want, completer)

fun WantMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Want, completer)

fun WantMapper.selectByPrimaryKey(wantId_: Int) =
    selectOne {
        where(wantId, isEqualTo(wantId_))
    }

fun WantMapper.selectAll() =
    select {
        allRows()
    }

fun WantMapper.selectMyAll(_account: String) =
    select {
        where(account, isEqualTo(_account))
    }

fun WantMapper.selectByKey(key: String) =
    select {
        where(title, SqlBuilder.isLike("%$key%"))
    }

fun WantMapper.update(completer: UpdateCompleter) =
    update(this::update, Want, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: WantRecord) =
    apply {
        set(wantId).equalTo(record::wantId)
        set(account).equalTo(record::account)
        set(title).equalTo(record::title)
        set(description).equalTo(record::description)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: WantRecord) =
    apply {
        set(wantId).equalToWhenPresent(record::wantId)
        set(account).equalToWhenPresent(record::account)
        set(title).equalToWhenPresent(record::title)
        set(description).equalToWhenPresent(record::description)
    }

fun WantMapper.updateByPrimaryKey(record: WantRecord) =
    update {
        set(account).equalTo(record::account)
        set(title).equalTo(record::title)
        set(description).equalTo(record::description)
        where(wantId, isEqualTo(record::wantId))
    }

fun WantMapper.updateByPrimaryKeySelective(record: WantRecord) =
    update {
        set(account).equalToWhenPresent(record::account)
        set(title).equalToWhenPresent(record::title)
        set(description).equalToWhenPresent(record::description)
        where(wantId, isEqualTo(record::wantId))
    }