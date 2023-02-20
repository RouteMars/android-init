package com.example.testapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Album (
    val userId: Int,
    val id: Int,
    val title: String,
    val comment: String = "default comment"
)