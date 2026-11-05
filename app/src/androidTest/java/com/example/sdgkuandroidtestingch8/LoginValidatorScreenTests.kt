package com.example.sdgkuandroidtestingch8

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginValidatorScreenTests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup(){
        composeTestRule.setContent {
            LoginValidatorScreen()
        }

    }

    @Test
    fun emptyEmailShowsError(){
        composeTestRule.onNodeWithTag("LoginButton").performClick()
        composeTestRule.onNodeWithTag("LoginFeedback").assertTextEquals("Email cannot be empty")

    }

    @Test
    fun invalidEmailShowsError(){
        composeTestRule.onNodeWithTag("EmailField").performTextInput("dan.moreno.sdgku.edu")
        composeTestRule.onNodeWithTag("LoginButton").performClick()

        composeTestRule.onNodeWithTag("LoginFeedback").assertTextEquals("Email is invalid")

    }

    @Test
    fun shortPassword(){
        composeTestRule.onNodeWithTag("EmailField").performTextInput("dan.moreno@sdgku.edu")
        composeTestRule.onNodeWithTag("PasswordField").performTextInput("Pass")

        composeTestRule.onNodeWithTag("LoginButton").performClick()

        composeTestRule.onNodeWithTag("LoginFeedback").assertTextEquals("Password must be at least 12 chars")

    }

    @Test
    fun loginSuccessful(){
        composeTestRule.onNodeWithTag("EmailField").performTextInput("dan.moreno@sdgku.edu")
        composeTestRule.onNodeWithTag("PasswordField").performTextInput("validPassword123")
        composeTestRule.onNodeWithTag("LoginButton").performClick()

        composeTestRule.onNodeWithTag("LoginFeedback").assertTextEquals("Login Successful")

    }




}