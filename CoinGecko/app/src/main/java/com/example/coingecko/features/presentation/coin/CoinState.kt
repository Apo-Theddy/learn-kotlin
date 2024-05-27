package com.example.coingecko.features.presentation.coin

import com.example.coingecko.features.domain.model.Coin
import com.example.coingecko.features.domain.model.CoinDetail
import javax.inject.Inject

class CoinState @Inject constructor(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
) {
}