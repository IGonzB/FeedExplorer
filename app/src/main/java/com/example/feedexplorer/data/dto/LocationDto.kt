package com.example.feedexplorer.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class LocationDto(
    @SerialName("city")
    val city: String,
    @SerialName("state")
    val state: String
)