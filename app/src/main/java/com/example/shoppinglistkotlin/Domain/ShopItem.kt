package com.example.shoppinglistkotlin.Domain

data class ShopItem(
    val id: Int,
    val name: String,
    val count: Int,
    val enable: Boolean
)
