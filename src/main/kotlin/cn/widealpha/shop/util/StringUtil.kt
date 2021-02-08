package cn.widealpha.shop.util

import java.util.*

object StringUtil {
    fun isEmpty(vararg string: String?): Boolean {
        string.forEach { if (it?.trim() ?: "" == "") return true }
        return false
    }
}