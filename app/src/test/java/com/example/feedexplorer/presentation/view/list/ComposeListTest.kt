package com.example.feedexplorer.presentation.view.list

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasProgressBarRangeInfo
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.feedexplorer.domain.model.Professional
import com.example.feedexplorer.domain.model.Resource
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class ComposeListTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Ignore("WIP")
    @Test
    fun listContent_showsLoading_whenStateIsLoading() {
        composeTestRule.setContent {
            MaterialTheme {
                ProfessionalListContent(
                    state = Resource.Loading,
                    onItemClick = {},
                    onRetry = {}
                )
            }
        }

        // Verify the progress indicator is displayed
        composeTestRule.onNode(hasProgressBarRangeInfo(ProgressBarRangeInfo.Indeterminate))
            .assertIsDisplayed()
    }

    @Ignore("WIP")
    @Test
    fun listContent_clicksItem_triggersCallback() {
        var clickedItem: Professional? = null
        val mockProfessional = Professional("1", "Dr. Pham", "Cardiology", "Houston", true)

        composeTestRule.setContent {
            MaterialTheme {
                ProfessionalListContent(
                    state = Resource.Success(listOf(mockProfessional)),
                    onItemClick = { clickedItem = it },
                    onRetry = {}
                )
            }
        }

        // Act: Perform a click on the item containing the name
        composeTestRule.onNodeWithText("Dr. Pham").performClick()

        // Assert: Check if our callback was triggered with the right data
        assert(clickedItem?.id == "1")
    }
}