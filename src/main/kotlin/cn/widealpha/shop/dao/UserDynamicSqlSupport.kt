/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-02-05T01:47:03.1116241+08:00
 */
package cn.widealpha.shop.dao

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object UserDynamicSqlSupport {
    object User : SqlTable("user") {
        val account = column<String>("account", JDBCType.VARCHAR)

        val username = column<String>("username", JDBCType.VARCHAR)

        val password = column<String>("password", JDBCType.VARCHAR)
    }
}