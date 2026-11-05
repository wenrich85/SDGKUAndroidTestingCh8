package com.example.sdgkuandroidtestingch8.ui.theme

import com.example.sdgkuandroidtestingch8.models.Item
class ShoppingCart {

    val items = mutableListOf<Item>()

    fun addItem(item: Item){
        items.add(item)

    }

    fun totalPrice(): Double{
        return items.sumOf {
            it.price
        }
    }

    fun size() : Int{
        return items.size

    }

    fun removeItem(item: Item){
        items.remove(item)
    }


}