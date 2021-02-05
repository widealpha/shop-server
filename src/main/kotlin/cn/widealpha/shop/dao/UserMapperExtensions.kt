/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-02-05T01:47:03.1116241+08:00
 */
package cn.widealpha.shop.dao

import cn.widealpha.shop.dao.UserDynamicSqlSupport.User
import cn.widealpha.shop.dao.UserDynamicSqlSupport.User.account
import cn.widealpha.shop.dao.UserDynamicSqlSupport.User.password
import cn.widealpha.shop.dao.UserDynamicSqlSupport.User.username
import cn.widealpha.shop.domain.UserRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UserMapper.count(completer: CountCompleter) =
    countFrom(this::count, User, completer)

fun UserMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, User, completer)

fun UserMapper.deleteByPrimaryKey(account_: String) =
    delete {
        where(account, isEqualTo(account_))
    }

fun UserMapper.insert(record: UserRecord) =
    insert(this::insert, record, User) {
        map(account).toProperty("account")
        map(username).toProperty("username")
        map(password).toProperty("password")
    }

fun UserMapper.insertMultiple(records: Collection<UserRecord>) =
    insertMultiple(this::insertMultiple, records, User) {
        map(account).toProperty("account")
        map(username).toProperty("username")
        map(password).toProperty("password")
    }

fun UserMapper.insertMultiple(vararg records: UserRecord) =
    insertMultiple(records.toList())

fun UserMapper.insertSelective(record: UserRecord) =
    insert(this::insert, record, User) {
        map(account).toPropertyWhenPresent("account", record::account)
        map(username).toPropertyWhenPresent("username", record::username)
        map(password).toPropertyWhenPresent("password", record::password)
    }

private val columnList = listOf(account, username, password)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, User, completer)

fun UserMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, User, completer)

fun UserMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, User, completer)

fun UserMapper.selectByPrimaryKey(account_: String) =
    selectOne {
        where(account, isEqualTo(account_))
    }

fun UserMapper.update(completer: UpdateCompleter) =
    update(this::update, User, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UserRecord) =
    apply {
        set(account).equalTo(record::account)
        set(username).equalTo(record::username)
        set(password).equalTo(record::password)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UserRecord) =
    apply {
        set(account).equalToWhenPresent(record::account)
        set(username).equalToWhenPresent(record::username)
        set(password).equalToWhenPresent(record::password)
    }

fun UserMapper.updateByPrimaryKey(record: UserRecord) =
    update {
        set(username).equalTo(record::username)
        set(password).equalTo(record::password)
        where(account, isEqualTo(record::account))
    }

fun UserMapper.updateByPrimaryKeySelective(record: UserRecord) =
    update {
        set(username).equalToWhenPresent(record::username)
        set(password).equalToWhenPresent(record::password)
        where(account, isEqualTo(record::account))
    }

//fun UserMapper.updatePasswordByAccountAndPassword(newPassword: String, record: UserRecord) =
//    update {
//        set(password).equalTo(newPassword)
//        where(account, isEqualTo(record::account))
//        where(password, isEqualTo(record::password))
//    }
