package com.calorie.tracker.ui

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.calorie.tracker.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthFlowTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testLoginNavigation() {
        // Assuming there is a "Login" button or tab
        composeTestRule.onNodeWithText("Login", ignoreCase = true).performClick()
        
        // Assert we see email/password fields
        composeTestRule.onNodeWithText("Email", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithText("Password", ignoreCase = true).assertExists()
    }

    @Test
    fun testRegistrationFlow() {
        // Assuming there's a Register navigation element
        composeTestRule.onNodeWithText("Register", ignoreCase = true).performClick()
        
        // Input text
        composeTestRule.onNodeWithText("Email", ignoreCase = true).performTextInput("test@example.com")
        composeTestRule.onNodeWithText("Password", ignoreCase = true).performTextInput("password123")
        
        // Since we don't want to actually register in UI test, we just check if Sign Up button exists
        composeTestRule.onNodeWithText("Sign Up", ignoreCase = true).assertExists()
    }
}
