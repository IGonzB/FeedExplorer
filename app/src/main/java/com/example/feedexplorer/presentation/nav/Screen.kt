package com.example.feedexplorer.presentation.nav

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {
    @Serializable
    object List : Screen // The main feed

    @Serializable
    data class Detail(val id: String) : Screen // The detail screen with an ID argument
}