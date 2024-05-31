package com.example.freegameapp.domain.usecase

import com.example.freegameapp.domain.repository.FreeGamesRepository
import javax.inject.Inject

class FreeGamesUseCase @Inject constructor(private val repository: FreeGamesRepository) {
    operator fun invoke() = repository.getFreeGames()
}