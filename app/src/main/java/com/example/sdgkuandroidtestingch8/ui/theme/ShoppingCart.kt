package com.example.sdgkuandroidtestingch8.ui.theme

import com.example.sdgkuandroidtestingch8.models.Product

class ShoppingCart {

    val products = mutableListOf<Product>()

    fun addItem(product: Product) {
        products.add(product)
    }

    fun totalPrice(): Double {
        val subtotal = products.sumOf { it.price }
        return when {
            subtotal > 500.0 -> subtotal * 0.8   // 20% off
            subtotal > 200.0 -> subtotal * 0.9   // 10% off
            else -> subtotal
        }
    }

    fun size(): Int {
        return products.size
    }

    fun removeItem(product: Product) {
        products.remove(product)
    }
}