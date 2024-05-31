package com.example.freegameapp.domain.repository

import com.example.freegameapp.core.common.Resource
import com.example.freegameapp.domain.model.FreeGames
import kotlinx.coroutines.flow.Flow

interface FreeGamesRepository {
    fun getFreeGames(): Flow<Resource<List<FreeGames>>>
}