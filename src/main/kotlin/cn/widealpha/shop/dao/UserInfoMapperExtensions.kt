/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-02-07T01:06:07.605+08:00
 */
package cn.widealpha.shop.dao

import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo
import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo.account
import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo.age
import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo.headImage
import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo.introduction
import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo.location
import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo.name
import cn.widealpha.shop.dao.UserInfoDynamicSqlSupport.UserInfo.sex
import cn.widealpha.shop.domain.UserInfoRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UserInfoMapper.count(completer: CountCompleter) =
        countFrom(this::count, UserInfo, completer)

fun UserInfoMapper.delete(completer: DeleteCompleter) =
        deleteFrom(this::delete, UserInfo, completer)

fun UserInfoMapper.deleteByPrimaryKey(account_: String) =
        delete {
            where(account, isEqualTo(account_))
        }

fun UserInfoMapper.insert(record: UserInfoRecord) =
        insert(this::insert, record, UserInfo) {
            map(account).toProperty("account")
            map(headImage).toProperty("headImage")
            map(age).toProperty("age")
            map(location).toProperty("location")
            map(introduction).toProperty("introduction")
            map(sex).toProperty("sex")
            map(name).toProperty("name")
        }

fun UserInfoMapper.insertMultiple(records: Collection<UserInfoRecord>) =
        insertMultiple(this::insertMultiple, records, UserInfo) {
            map(account).toProperty("account")
            map(headImage).toProperty("headImage")
            map(age).toProperty("age")
            map(location).toProperty("location")
            map(introduction).toProperty("introduction")
            map(sex).toProperty("sex")
            map(name).toProperty("name")
        }

fun UserInfoMapper.insertMultiple(vararg records: UserInfoRecord) =
        insertMultiple(records.toList())

fun UserInfoMapper.insertSelective(record: UserInfoRecord) =
        insert(this::insert, record, UserInfo) {
            map(account).toPropertyWhenPresent("account", record::account)
            map(headImage).toPropertyWhenPresent("headImage", record::headImage)
            map(age).toPropertyWhenPresent("age", record::age)
            map(location).toPropertyWhenPresent("location", record::location)
            map(introduction).toPropertyWhenPresent("introduction", record::introduction)
            map(sex).toPropertyWhenPresent("sex", record::sex)
            map(name).toPropertyWhenPresent("name", record::name)
        }

private val columnList = listOf(account, headImage, age, location, introduction, sex, name)

fun UserInfoMapper.selectOne(completer: SelectCompleter) =
        selectOne(this::selectOne, columnList, UserInfo, completer)

fun UserInfoMapper.select(completer: SelectCompleter) =
        selectList(this::selectMany, columnList, UserInfo, completer)

fun UserInfoMapper.selectDistinct(completer: SelectCompleter) =
        selectDistinct(this::selectMany, columnList, UserInfo, completer)

fun UserInfoMapper.selectByPrimaryKey(account_: String) =
        selectOne {
            where(account, isEqualTo(account_))
        }

fun UserInfoMapper.update(completer: UpdateCompleter) =
        update(this::update, UserInfo, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UserInfoRecord) =
        apply {
            set(account).equalTo(record::account)
            set(headImage).equalTo(record::headImage)
            set(age).equalTo(record::age)
            set(location).equalTo(record::location)
            set(introduction).equalTo(record::introduction)
            set(sex).equalTo(record::sex)
            set(name).equalTo(record::name)
        }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UserInfoRecord) =
        apply {
            set(account).equalToWhenPresent(record::account)
            set(headImage).equalToWhenPresent(record::headImage)
            set(age).equalToWhenPresent(record::age)
            set(location).equalToWhenPresent(record::location)
            set(introduction).equalToWhenPresent(record::introduction)
            set(sex).equalToWhenPresent(record::sex)
            set(name).equalToWhenPresent(record::name)
        }

fun UserInfoMapper.updateByPrimaryKey(record: UserInfoRecord) =
        update {
            set(headImage).equalTo(record::headImage)
            set(age).equalTo(record::age)
            set(location).equalTo(record::location)
            set(introduction).equalTo(record::introduction)
            set(sex).equalTo(record::sex)
            set(name).equalTo(record::name)
            where(account, isEqualTo(record::account))
        }

fun UserInfoMapper.updateByPrimaryKeySelective(record: UserInfoRecord) =
        update {
            set(headImage).equalToWhenPresent(record::headImage)
            set(age).equalToWhenPresent(record::age)
            set(location).equalToWhenPresent(record::location)
            set(introduction).equalToWhenPresent(record::introduction)
            set(sex).equalToWhenPresent(record::sex)
            set(name).equalToWhenPresent(record::name)
            where(account, isEqualTo(record::account))
        }