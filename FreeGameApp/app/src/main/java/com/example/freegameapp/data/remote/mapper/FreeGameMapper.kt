package com.example.freegameapp.data.remote.mapper

import com.example.freegameapp.data.remote.dto.FreeGamesDto
import com.example.freegameapp.domain.model.FreeGames

fun FreeGamesDto.toDomainFreeGames(): FreeGames {
    return FreeGames(gameUrl,id,shortDescription,thumbnail,title)
}