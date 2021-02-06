/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-02-07T02:30:40.196+08:00
 */
package cn.widealpha.shop.dao

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object WantDynamicSqlSupport {
    object Want : SqlTable("want") {
        val wantId = column<Int>("want_id", JDBCType.INTEGER)

        val account = column<String>("account", JDBCType.VARCHAR)

        val title = column<String>("title", JDBCType.VARCHAR)

        val message = column<String>("message", JDBCType.VARCHAR)
    }
}