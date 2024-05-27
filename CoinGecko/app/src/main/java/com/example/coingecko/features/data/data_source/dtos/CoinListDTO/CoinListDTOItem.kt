package com.example.coingecko.features.data.data_source.dtos.CoinListDTO

import com.example.coingecko.features.domain.model.Coin

data class CoinListDTOItem(
    val ath: Double,
    val ath_change_percentage: Double,
    val ath_date: String,
    val atl: Double,
    val atl_change_percentage: Double,
    val atl_date: String,
    val circulating_supply: Int,
    val current_price: Double,
    val fully_diluted_valuation: Double,
    val high_24h: Double,
    val id: String,
    val image: String,
    val last_updated: String,
    val low_24h: Double,
    val market_cap: Int,
    val market_cap_change_24h: Int,
    val market_cap_change_percentage_24h: Int,
    val market_cap_rank: Any,
    val max_supply: Long,
    val name: String,
    val price_change_24h: Double,
    val price_change_percentage_24h: Double,
    val roi: Any,
    val symbol: String,
    val total_supply: Double,
    val total_volume: Double
) {
    fun toCoin(): Coin {
        return Coin(
            id = id,
            name = name,
            image = image,
            market_cap = market_cap.toLong(),
            price = current_price,
            price_percentage_change = price_change_percentage_24h,
            low_price = low_24h,
            high_price = high_24h
        )
    }
}