package com.example.shoppinglistkotlin.Domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopList(shopItem: ShopItem) {
        shopListRepository.editShopList(shopItem)
    }
}