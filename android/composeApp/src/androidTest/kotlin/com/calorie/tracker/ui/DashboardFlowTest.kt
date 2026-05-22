package com.calorie.tracker.ui

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.calorie.tracker.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DashboardFlowTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testDashboardInitialState() {
        // Assume Dashboard is loaded or we navigate to it
        // The dashboard should show "Calories", "Water", "Weight"
        composeTestRule.onNodeWithText("Calories", ignoreCase = true, substring = true).assertExists()
        composeTestRule.onNodeWithText("Water", ignoreCase = true, substring = true).assertExists()
    }
}
