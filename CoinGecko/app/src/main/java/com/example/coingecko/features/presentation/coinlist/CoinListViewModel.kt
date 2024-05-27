package com.example.coingecko.features.presentation.coinlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coingecko.features.domain.use_case.CoinListUseCase
import com.example.coingecko.features.util.ResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoinListViewModel @Inject constructor(
    private val coinUseCase: CoinListUseCase
) : ViewModel() {
    private val coinListValue = MutableStateFlow(CoinListState())
    var _coinListValue: StateFlow<CoinListState> = coinListValue

    fun getAllCoins(page: String) = viewModelScope.launch(Dispatchers.IO) {
        coinUseCase(page).collect {
            when (it) {
                is ResponseState.Success -> {
                    coinListValue.value = CoinListState(coinList = it.data ?: emptyList())
                }
                is ResponseState.Loading -> {
                    coinListValue.value = CoinListState(isLoading = true)
                }
                is ResponseState.Error -> {
                    coinListValue.value = CoinListState(error = it.message ?: "An Unexpected Error")
                }
            }
        }
    }
}