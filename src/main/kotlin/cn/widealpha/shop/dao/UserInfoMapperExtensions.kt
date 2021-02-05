/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-02-05T01:47:03.0960425+08:00
 */
package cn.widealpha.shop.dao

import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo
import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo.account
import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo.age
import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo.headImage
import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo.infoId
import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo.introduction
import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo.location
import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo.sex
import cn.widealpha.shop.domain.UserInfoRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UserInfoMapper.count(completer: CountCompleter) =
    countFrom(this::count, UserInfo, completer)

fun UserInfoMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, UserInfo, completer)

fun UserInfoMapper.deleteByPrimaryKey(infoId_: Int) =
    delete {
        where(infoId, isEqualTo(infoId_))
    }

fun UserInfoMapper.insert(record: UserInfoRecord) =
    insert(this::insert, record, UserInfo) {
        map(infoId).toProperty("infoId")
        map(account).toProperty("account")
        map(headImage).toProperty("headImage")
        map(sex).toProperty("sex")
        map(location).toProperty("location")
        map(introduction).toProperty("introduction")
        map(age).toProperty("age")
    }

fun UserInfoMapper.insertMultiple(records: Collection<UserInfoRecord>) =
    insertMultiple(this::insertMultiple, records, UserInfo) {
        map(infoId).toProperty("infoId")
        map(account).toProperty("account")
        map(headImage).toProperty("headImage")
        map(sex).toProperty("sex")
        map(location).toProperty("location")
        map(introduction).toProperty("introduction")
        map(age).toProperty("age")
    }

fun UserInfoMapper.insertMultiple(vararg records: UserInfoRecord) =
    insertMultiple(records.toList())

fun UserInfoMapper.insertSelective(record: UserInfoRecord) =
    insert(this::insert, record, UserInfo) {
        map(infoId).toPropertyWhenPresent("infoId", record::infoId)
        map(account).toPropertyWhenPresent("account", record::account)
        map(headImage).toPropertyWhenPresent("headImage", record::headImage)
        map(sex).toPropertyWhenPresent("sex", record::sex)
        map(location).toPropertyWhenPresent("location", record::location)
        map(introduction).toPropertyWhenPresent("introduction", record::introduction)
        map(age).toPropertyWhenPresent("age", record::age)
    }

private val columnList = listOf(infoId, account, headImage, sex, location, introduction, age)

fun UserInfoMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, UserInfo, completer)

fun UserInfoMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, UserInfo, completer)

fun UserInfoMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, UserInfo, completer)

fun UserInfoMapper.selectByPrimaryKey(infoId_: Int) =
    selectOne {
        where(infoId, isEqualTo(infoId_))
    }

fun UserInfoMapper.update(completer: UpdateCompleter) =
    update(this::update, UserInfo, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UserInfoRecord) =
    apply {
        set(infoId).equalTo(record::infoId)
        set(account).equalTo(record::account)
        set(headImage).equalTo(record::headImage)
        set(sex).equalTo(record::sex)
        set(location).equalTo(record::location)
        set(introduction).equalTo(record::introduction)
        set(age).equalTo(record::age)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UserInfoRecord) =
    apply {
        set(infoId).equalToWhenPresent(record::infoId)
        set(account).equalToWhenPresent(record::account)
        set(headImage).equalToWhenPresent(record::headImage)
        set(sex).equalToWhenPresent(record::sex)
        set(location).equalToWhenPresent(record::location)
        set(introduction).equalToWhenPresent(record::introduction)
        set(age).equalToWhenPresent(record::age)
    }

fun UserInfoMapper.updateByPrimaryKey(record: UserInfoRecord) =
    update {
        set(account).equalTo(record::account)
        set(headImage).equalTo(record::headImage)
        set(sex).equalTo(record::sex)
        set(location).equalTo(record::location)
        set(introduction).equalTo(record::introduction)
        set(age).equalTo(record::age)
        where(infoId, isEqualTo(record::infoId))
    }

fun UserInfoMapper.updateByPrimaryKeySelective(record: UserInfoRecord) =
    update {
        set(account).equalToWhenPresent(record::account)
        set(headImage).equalToWhenPresent(record::headImage)
        set(sex).equalToWhenPresent(record::sex)
        set(location).equalToWhenPresent(record::location)
        set(introduction).equalToWhenPresent(record::introduction)
        set(age).equalToWhenPresent(record::age)
        where(infoId, isEqualTo(record::infoId))
    }