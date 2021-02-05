/*
 * Auto-generated file. Created by MyBatis Generator
 * Generation date: 2021-02-05T01:47:03.0960425+08:00
 */
package cn.widealpha.shop.dao

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object UserInfoDynamicSqlSupport {
    object UserInfo : SqlTable("user_info") {
        val infoId = column<Int>("info_id", JDBCType.INTEGER)

        val account = column<String>("account", JDBCType.VARCHAR)

        val headImage = column<String>("head_image", JDBCType.VARCHAR)

        val sex = column<Int>("sex", JDBCType.INTEGER)

        val location = column<String>("location", JDBCType.VARCHAR)

        val introduction = column<String>("introduction", JDBCType.VARCHAR)

        val age = column<Int>("age", JDBCType.INTEGER)
    }
}