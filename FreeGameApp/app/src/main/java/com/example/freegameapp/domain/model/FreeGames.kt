package com.example.freegameapp.domain.model

import com.google.gson.annotations.SerializedName

data class FreeGames(
    val gameUrl: String,
    val id: Int,
    val shortDescription: String,
    val thumbnail: String,
    val title: String
)