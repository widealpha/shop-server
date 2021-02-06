/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-02-07T01:06:07.589+08:00
 */
package cn.widealpha.shop.dao

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object UserInfoDynamicSqlSupport {
    object UserInfo : SqlTable("user_info") {
        val account = column<String>("account", JDBCType.VARCHAR)

        val headImage = column<String>("head_image", JDBCType.VARCHAR)

        val age = column<Int>("age", JDBCType.INTEGER)

        val location = column<String>("location", JDBCType.VARCHAR)

        val introduction = column<String>("introduction", JDBCType.VARCHAR)

        val sex = column<Int>("sex", JDBCType.INTEGER)

        val name = column<String>("name", JDBCType.VARCHAR)
    }
}