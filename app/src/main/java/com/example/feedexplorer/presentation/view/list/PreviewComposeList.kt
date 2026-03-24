package com.example.feedexplorer.presentation.view.list

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.feedexplorer.domain.model.Professional
import com.example.feedexplorer.domain.model.Resource
import com.example.feedexplorer.presentation.theme.FeedExplorerTheme
import com.example.feedexplorer.presentation.view.detail.mockProfessional

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewProfessionalItem() {
    FeedExplorerTheme {
        ProfessionalItem(
            professional = mockProfessional,
            onClick = {}
        )
    }
}

@Preview(showSystemUi = true, name = "Success State")
@Composable
fun PreviewListSuccess() {
    FeedExplorerTheme {
        ProfessionalListContent(
            state = Resource.Success(
                listOf(mock1, mock2)
            ),
            onItemClick = {},
            onRetry = {}
        )
    }
}

@Preview(showSystemUi = true, name = "Loading State")
@Composable
fun PreviewListLoading() {
    FeedExplorerTheme {
        ProfessionalListContent(
            state = Resource.Loading,
            onItemClick = {},
            onRetry = {}
        )
    }
}

@Preview(showSystemUi = true, name = "Error State")
@Composable
fun PreviewListError() {
    FeedExplorerTheme {
        ProfessionalListContent(
            state = Resource.Error("No Internet Connection"),
            onItemClick = {},
            onRetry = {}
        )
    }
}

val mock1 = Professional("1", "Dr. House", "Diagnostics", "Princeton, NJ", false)
val mock2 = Professional("2", "Dr. Strange", "Neurosurgery", "New York, NY", true)
