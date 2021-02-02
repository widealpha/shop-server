package cn.widealpha.shop.domain

import com.alibaba.fastjson.JSONObject

class Result(var code: Int, var message: String, var data: Any?) {

    override fun toString(): String {
        return JSONObject.toJSONString(this)
    }

    companion object {
        fun success(message: String): Result {
            return Result(0, message, null)
        }

        fun success(message: String, data: Any?): Result {
            return Result(0, message, data)
        }

        fun data(data: Any?): Result {
            return success("success", data)
        }

        fun error(message: String): Result {
            return Result(-1, message, null)
        }

        fun error(message: String, data: Any?): Result {
            return Result(-1, message, data)
        }

        fun error(code: Int, message: String): Result {
            return Result(code, message, null)
        }
    }
}