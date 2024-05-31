package com.example.coingecko.features.data.repository

import com.example.coingecko.features.data.data_source.CoinGeckoApi
import com.example.coingecko.features.data.data_source.dtos.CoinDetailDTO.CoinDetailDTO
import com.example.coingecko.features.data.data_source.dtos.CoinListDTO.CoinListDTO
import com.example.coingecko.features.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi:CoinGeckoApi
):CoinRepository {
    override suspend fun getAllCoins(page: String): CoinListDTO {
        return coinApi.getAllCoins(page = page)
    }

    override suspend fun getCoinById(id: String): CoinDetailDTO {
        return coinApi.getCoinById(id = id)
    }
}