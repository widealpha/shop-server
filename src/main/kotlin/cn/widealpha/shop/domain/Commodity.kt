package cn.widealpha.shop.domain

data class Commodity(
    var goodId: Int,
    var title: String,
    var description: String,
    var price: Double,
    var catagory: String,
    var image: String
)