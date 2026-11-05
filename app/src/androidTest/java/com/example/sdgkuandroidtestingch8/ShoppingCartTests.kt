package com.example.sdgkuandroidtestingch8

import com.example.sdgkuandroidtestingch8.ui.theme.ShoppingCart
import  com.example.sdgkuandroidtestingch8.models.Item
import org.junit.Before
import org.junit.Test

class ShoppingCartTests {

        var cart = ShoppingCart()

    @Before
    fun setup() {
        cart = ShoppingCart()
    }


    @Test
    fun shoppingCart_isEmpty(){
        val size = cart.size()
        assert(size == 0)
    }

    @Test
    fun shoppinCart_totalPriceIsZero(){
        val totalPrice = cart.totalPrice()

        assert(totalPrice == 0.0)
    }

    @Test
    fun whenAddingItemToShoppingCart_sizeIncreases(){
        val item = Item("Item 1", 10.0)

        cart.addItem(item)

        assert(cart.size() == 1)
    }

    /**
    * TDD Exercise: Shopping Cart
    * 1. Create a ShoppingCart

    * 2. When the shopping cart is empty, the size should be 0
    * 3. When the shopping cart is empty the total price should be 0.0
    * 4. When an item is added to the shopping cart, the size should be 1
    * 5. When items are added to the shopping cart, the total price should be X

    * 6. When an item is removed from the shopping cart, the size should decrease by 1
    * 7. When the total is greater than 200.0, a discount of 10% should be applied
    * 8. When the total is greater than 500.0, a discount of 20% should be applied
    */

    @Test
    fun whenAddingItemsToShoppingCart_totalPriceIncreases(){
        val item = Item("Item 2", 15.0)

        cart.addItem(item)
        cart.addItem(item)

        assert(cart.totalPrice() == 30.0)


//        assert()
    }

    @Test
    fun whenItemIsRemovedFromShoppingCart_sizeDecreasesByOne(){
        val item = Item("Item", 20.0)
        cart.addItem(item)
        cart.addItem(item)
        cart.removeItem(item)

        assert(cart.size() == 1)

    }
}