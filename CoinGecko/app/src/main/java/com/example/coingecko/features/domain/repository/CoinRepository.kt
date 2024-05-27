package com.example.coingecko.features.domain.repository

import com.example.coingecko.features.data.data_source.dtos.CoinDetailDTO.CoinDetailDTO
import com.example.coingecko.features.data.data_source.dtos.CoinListDTO.CoinListDTO

interface CoinRepository {
    suspend fun getAllCoins(page: String): CoinListDTO
    suspend fun getCoinById(id: String): CoinDetailDTO
}
