package com.example.freegameapp.data.repository

import com.example.freegameapp.core.common.Resource
import com.example.freegameapp.data.remote.FreeGameApi
import com.example.freegameapp.data.remote.mapper.toDomainFreeGames
import com.example.freegameapp.domain.model.FreeGames
import com.example.freegameapp.domain.repository.FreeGamesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FreeGameRepositoryImpl @Inject constructor(private val freeGameApi: FreeGameApi) : FreeGamesRepository {
    override fun getFreeGames(): Flow<Resource<List<FreeGames>>> = flow {
        emit(Resource.Loading())
        try {
            val result = freeGameApi.getFreeGame().map { it.toDomainFreeGames() }
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }
}