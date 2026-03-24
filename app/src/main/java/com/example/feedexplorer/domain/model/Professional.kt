package com.example.feedexplorer.domain.model

data class Professional(
    val id: String,
    val displayName: String,
    val specialty: String,
    val fullLocation: String,
    val isAvailable: Boolean
)
