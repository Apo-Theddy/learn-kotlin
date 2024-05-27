package com.example.coingecko.features.presentation.coinlist

import com.example.coingecko.features.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coinList: List<Coin> = emptyList(),
    val error: String = ""
)
