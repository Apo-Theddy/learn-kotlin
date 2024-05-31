package com.example.freegameapp.presentation.free_game.state

import com.example.freegameapp.domain.model.FreeGames

data class FreeGameState(
    val freeGames: List<FreeGames>? = emptyList(),
    val errorMsg: String? = "",
    val isLoading: Boolean = false
)