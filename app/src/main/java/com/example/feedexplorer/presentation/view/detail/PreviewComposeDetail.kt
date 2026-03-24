package com.example.feedexplorer.presentation.view.detail

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.feedexplorer.domain.model.Professional
import com.example.feedexplorer.domain.model.Resource
import com.example.feedexplorer.presentation.theme.FeedExplorerTheme
import com.example.feedexplorer.presentation.view.list.mock1

@Preview(showSystemUi = true, name = "Loading")
@Composable
fun PreviewDetailLoading() {
    FeedExplorerTheme {
        ProfessionalDetailContent(
            state = Resource.Loading,
            professionalId = mockProfessional.id,
            onBackClick = {}
        )
    }
}

@Preview(
    showSystemUi = true,
    name = "Selected Professional Night",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewDetailSelectedNight() {
    FeedExplorerTheme {
        ProfessionalDetailContent(
            state = Resource.Success(
                mock1
            ),
            professionalId = mockProfessional.id,
            onBackClick = {}
        )
    }
}

@Preview(
    showSystemUi = true,
    name = "Selected Professional",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PreviewDetailSelectedNormal() {
    FeedExplorerTheme {
        ProfessionalDetailContent(
            state = Resource.Success(
                mock1
            ),
            professionalId = mockProfessional.id,
            onBackClick = {}
        )
    }
}

val mockProfessional = Professional(
    id = "1",
    displayName = "Duc Thinh Pham, MD",
    specialty = "Cardiology",
    fullLocation = "Houston, TX",
    isAvailable = true
)
