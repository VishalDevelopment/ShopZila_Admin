package com.example.shoppingadmin.DomainLayer.Model

data class CategoryModel(
    var name:String="",
    val date:Long=System.currentTimeMillis(),
    val createBy:String="",
    val imageUrl :String=""
)
