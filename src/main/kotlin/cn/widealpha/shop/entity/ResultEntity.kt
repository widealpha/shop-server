package cn.widealpha.shop.entity

import com.alibaba.fastjson.JSONObject

class ResultEntity(var code: Int, var message: String, var data: Any?) {

    override fun toString(): String {
        return JSONObject.toJSONString(this)
    }

    companion object {
        fun success(message: String): ResultEntity {
            return ResultEntity(0, message, null)
        }

        fun success(message: String, data: Any?): ResultEntity {
            return ResultEntity(0, message, data)
        }

        fun data(data: Any?): ResultEntity {
            return success("success", data)
        }

        fun error(message: String): ResultEntity {
            return ResultEntity(-1, message, null)
        }

        fun error(message: String, data: Any?): ResultEntity {
            return ResultEntity(-1, message, data)
        }

        fun error(code: Int, message: String): ResultEntity {
            return ResultEntity(code, message, null)
        }
    }
}