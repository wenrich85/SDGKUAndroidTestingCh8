package com.example.sdgkuandroidtestingch8

import com.example.sdgkuandroidtestingch8.models.Product
import com.example.sdgkuandroidtestingch8.ui.theme.ShoppingCart
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

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
class ShoppingCartTests {

    private lateinit var cart: ShoppingCart

    @Before
    fun setup() {
        cart = ShoppingCart()
    }

    @Test
    fun shoppingCart_isEmpty() {
        assertEquals(0, cart.size())
    }

    @Test
    fun shoppingCart_totalPriceIsZero() {
        assertEquals(0.0, cart.totalPrice(), 0.001)
    }

    @Test
    fun whenAddingItemToShoppingCart_sizeIncreases() {
        cart.addItem(Product("Item 1", 10.0))
        assertEquals(1, cart.size())
    }

    @Test
    fun whenAddingItemsToShoppingCart_totalPriceIncreases() {
        val product = Product("Item 2", 15.0)
        cart.addItem(product)
        cart.addItem(product)
        assertEquals(30.0, cart.totalPrice(), 0.001)
    }

    @Test
    fun whenItemIsRemovedFromShoppingCart_sizeDecreasesByOne() {
        val product = Product("Item", 20.0)
        cart.addItem(product)
        cart.addItem(product)
        cart.removeItem(product)
        assertEquals(1, cart.size())
    }


    @Test
    fun whenTotalIsGreaterThan200_tenPercentDiscountApplied() {
        cart.addItem(Product("Item 1", 150.0))
        cart.addItem(Product("Item 2", 100.0)) // 250.0 before discount
        assertEquals(225.0, cart.totalPrice(), 0.001)
    }

    @Test
    fun whenTotalIsExactly200_noDiscountApplied() {
        cart.addItem(Product("Item A", 200.0))
        assertEquals(200.0, cart.totalPrice(), 0.001)
    }


    @Test
    fun whenTotalIsGreaterThan500_twentyPercentDiscountApplied() {
        cart.addItem(Product("Item A", 400.0))
        cart.addItem(Product("Item B", 200.0)) // 600.0 before discount
        assertEquals(480.0, cart.totalPrice(), 0.001)
    }
}


