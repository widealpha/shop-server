/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-02-07T02:30:40.165+08:00
 */
package cn.widealpha.shop.dao

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object CommodityDynamicSqlSupport {
    object Commodity : SqlTable("commodity") {
        val commodityId = column<Int>("commodity_id", JDBCType.INTEGER)

        val title = column<String>("title", JDBCType.VARCHAR)

        val description = column<String>("description", JDBCType.VARCHAR)

        val price = column<Double>("price", JDBCType.DOUBLE)

        val category = column<String>("category", JDBCType.VARCHAR)

        val image = column<String>("image", JDBCType.VARCHAR)

        val account = column<String>("account", JDBCType.VARCHAR)
    }
}