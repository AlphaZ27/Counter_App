package com.example.counterapp

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.*
import org.junit.Rule
import org.junit.Test

class CounterAppTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun counter_increments_when_button_clicked() {
        // Check initial count is 0
        composeTestRule.onNodeWithTag("countText").assertExists()

        // Click increment button
        composeTestRule.onNodeWithText("Increment").performClick()

        // Verify the count increments
        composeTestRule.onNodeWithText("Count: 1").assertExists()
    }

    @Test
    fun multiple_clicks_increase_count_properly() {
        // Create a constant that is assigned to the increment button
        val incrementButton = composeTestRule.onNodeWithText("Increment")

        // Repeat function repeats the number given
        // incrementButton is given the perform click action
        repeat(3) { incrementButton.performClick() }

        // Verifies the count increments
        composeTestRule.onNodeWithText("Count: 3").assertExists()
    }
}