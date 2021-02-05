package cn.widealpha.shop.util

import java.util.*

class StringUtil {
    companion object {
        fun isEmpty(vararg string: String?): Boolean {
            string.forEach { if (it?.trim() ?: "" == "") return true }
            return false
        }
    }
}