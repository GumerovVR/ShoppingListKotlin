package com.example.shoppinglistkotlin.Domain

interface ShopListRepository {
    fun getShopList(): List<ShopItem>

    fun getShopItem(shopItemId: Int): ShopItem

    fun addShopItem(shopItem: ShopItem)

    fun editShopList(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)
}