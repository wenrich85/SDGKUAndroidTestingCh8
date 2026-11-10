package com.example.sdgkuandroidtestingch8

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isNotChecked
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginValidatorScreenTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            LoginValidatorScreen()
        }
    }

    @Test
    fun emptyEmailShowsError() {
        composeTestRule.onNodeWithTag("LoginButton").performClick()

        composeTestRule.onNodeWithTag("LoginFeedback")
            .assertTextEquals("Email cannot be empty")
    }

    @Test
    fun invalidEmailShowsError() {
        composeTestRule.onNodeWithTag("EmailField").performTextInput("dan.moreno.sdgku.edu")
        composeTestRule.onNodeWithTag("LoginButton").performClick()

        composeTestRule.onNodeWithTag("LoginFeedback")
            .assertTextEquals("Email is invalid")
    }

    @Test
    fun shortPassword() {
        composeTestRule.onNodeWithTag("EmailField").performTextInput("dan.moreno@sdgku.edu")
        composeTestRule.onNodeWithTag("PasswordField").performTextInput("Pass")
        composeTestRule.onNodeWithTag("LoginButton").performClick()

        composeTestRule.onNodeWithTag("LoginFeedback")
            .assertTextEquals("Password must be at least 12 chars")
    }

    @Test
    fun rememberMeCheckboxChangesStateWhenChecked() {
        onView(withId(R.id.remember_me_checkbox))
            .check(matches(isDisplayed()))
            .check(matches(isNotChecked()))

        onView(withId(R.id.remember_me_text))
            .check(matches(isDisplayed()))
            .check(matches(withText("Remember me is unchecked")))

        onView(withId(R.id.remember_me_checkbox))
            .perform(click())
            .check(matches(isChecked()))

        onView(withId(R.id.remember_me_text))
            .check(matches(isDisplayed()))
            .check(matches(withText("Remember me is checked")))
    }
}