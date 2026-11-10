package com.example.sdgkuandroidtestingch8.ui.theme.shopping

import com.example.sdgkuandroidtestingch8.models.Product
import com.example.sdgkuandroidtestingch8.ui.theme.ShoppingCart

class ShopViewModel(
    private val productRepository: ProductRepository,
    private val shoppingCart: ShoppingCart = ShoppingCart()
) {
    val products get () = productRepository.getProducts()

    fun addToCart(product: Product){
        shoppingCart.addItem(product)

    }

    fun subtotalPrice(): Double {
        return shoppingCart.totalPrice()
    }
}