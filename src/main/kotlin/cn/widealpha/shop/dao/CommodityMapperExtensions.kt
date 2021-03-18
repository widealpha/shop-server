/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-02-07T02:30:40.18+08:00
 */
package cn.widealpha.shop.dao

import cn.widealpha.shop.dao.CommodityDynamicSqlSupport.Commodity
import cn.widealpha.shop.dao.CommodityDynamicSqlSupport.Commodity.account
import cn.widealpha.shop.dao.CommodityDynamicSqlSupport.Commodity.category
import cn.widealpha.shop.dao.CommodityDynamicSqlSupport.Commodity.commodityId
import cn.widealpha.shop.dao.CommodityDynamicSqlSupport.Commodity.description
import cn.widealpha.shop.dao.CommodityDynamicSqlSupport.Commodity.image
import cn.widealpha.shop.dao.CommodityDynamicSqlSupport.Commodity.price
import cn.widealpha.shop.dao.CommodityDynamicSqlSupport.Commodity.title
import cn.widealpha.shop.domain.CommodityRecord
import org.mybatis.dynamic.sql.SqlBuilder
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun CommodityMapper.count(completer: CountCompleter) =
        countFrom(this::count, Commodity, completer)

fun CommodityMapper.delete(completer: DeleteCompleter) =
        deleteFrom(this::delete, Commodity, completer)

fun CommodityMapper.deleteByPrimaryKey(commodityId_: Int) =
        delete {
            where(commodityId, isEqualTo(commodityId_))
        }

fun CommodityMapper.insert(record: CommodityRecord) =
        insert(this::insert, record, Commodity) {
            map(commodityId).toProperty("commodityId")
            map(title).toProperty("title")
            map(description).toProperty("description")
            map(price).toProperty("price")
            map(category).toProperty("category")
            map(image).toProperty("image")
            map(account).toProperty("account")
        }

fun CommodityMapper.insertMultiple(records: Collection<CommodityRecord>) =
        insertMultiple(this::insertMultiple, records, Commodity) {
            map(commodityId).toProperty("commodityId")
            map(title).toProperty("title")
            map(description).toProperty("description")
            map(price).toProperty("price")
            map(category).toProperty("category")
            map(image).toProperty("image")
            map(account).toProperty("account")
        }

fun CommodityMapper.insertMultiple(vararg records: CommodityRecord) =
        insertMultiple(records.toList())

fun CommodityMapper.insertSelective(record: CommodityRecord) =
        insert(this::insert, record, Commodity) {
            map(commodityId).toPropertyWhenPresent("commodityId", record::commodityId)
            map(title).toPropertyWhenPresent("title", record::title)
            map(description).toPropertyWhenPresent("description", record::description)
            map(price).toPropertyWhenPresent("price", record::price)
            map(category).toPropertyWhenPresent("category", record::category)
            map(image).toPropertyWhenPresent("image", record::image)
            map(account).toPropertyWhenPresent("account", record::account)
        }

private val columnList = listOf(commodityId, title, description, price, category, image, account)

fun CommodityMapper.selectOne(completer: SelectCompleter) =
        selectOne(this::selectOne, columnList, Commodity, completer)

fun CommodityMapper.select(completer: SelectCompleter) =
        selectList(this::selectMany, columnList, Commodity, completer)

fun CommodityMapper.selectDistinct(completer: SelectCompleter) =
        selectDistinct(this::selectMany, columnList, Commodity, completer)

fun CommodityMapper.selectByPrimaryKey(commodityId_: Int) =
        selectOne {
            where(commodityId, isEqualTo(commodityId_))
        }

fun CommodityMapper.selectAll() =
        select {
            allRows()
        }

fun CommodityMapper.selectMyAll(_account: String) =
        select {
            where(account, isEqualTo(_account))
        }

fun CommodityMapper.selectByKey(key: String) =
        select {
            where(title, SqlBuilder.isLike("%$key%"))
        }


fun CommodityMapper.update(completer: UpdateCompleter) =
        update(this::update, Commodity, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: CommodityRecord) =
        apply {
            set(commodityId).equalTo(record::commodityId)
            set(title).equalTo(record::title)
            set(description).equalTo(record::description)
            set(price).equalTo(record::price)
            set(category).equalTo(record::category)
            set(image).equalTo(record::image)
            set(account).equalTo(record::account)
        }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: CommodityRecord) =
        apply {
            set(commodityId).equalToWhenPresent(record::commodityId)
            set(title).equalToWhenPresent(record::title)
            set(description).equalToWhenPresent(record::description)
            set(price).equalToWhenPresent(record::price)
            set(category).equalToWhenPresent(record::category)
            set(image).equalToWhenPresent(record::image)
            set(account).equalToWhenPresent(record::account)
        }

fun CommodityMapper.updateByPrimaryKey(record: CommodityRecord) =
        update {
            set(title).equalTo(record::title)
            set(description).equalTo(record::description)
            set(price).equalTo(record::price)
            set(category).equalTo(record::category)
            set(image).equalTo(record::image)
            set(account).equalTo(record::account)
            where(commodityId, isEqualTo(record::commodityId))
        }

fun CommodityMapper.updateByPrimaryKeySelective(record: CommodityRecord) =
        update {
            set(title).equalToWhenPresent(record::title)
            set(description).equalToWhenPresent(record::description)
            set(price).equalToWhenPresent(record::price)
            set(category).equalToWhenPresent(record::category)
            set(image).equalToWhenPresent(record::image)
            set(account).equalToWhenPresent(record::account)
            where(commodityId, isEqualTo(record::commodityId))
        }