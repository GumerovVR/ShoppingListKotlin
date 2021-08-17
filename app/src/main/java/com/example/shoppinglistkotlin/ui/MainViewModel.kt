package com.example.shoppinglistkotlin.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglistkotlin.Data.ShopListRepositoryImpl
import com.example.shoppinglistkotlin.Domain.*

class MainViewModel : ViewModel() { // ViewModel(), а не AndroidViewModel() т.к. нам не нужен контекст

    // добавляем реализацию репозитория(это не правильно, пока инжект не знаю)
    private val repository = ShopListRepositoryImpl

    // добавляем UseCase
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list // устанавливаем в LiveData наш список
    }

    // дулаение объекта
    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
        getShopList()
    }

    // инверсия enabled у объекта shopItem
    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enable = !shopItem.enable)
        editShopItemUseCase.editShopList(newItem)
        getShopList()
    }

}