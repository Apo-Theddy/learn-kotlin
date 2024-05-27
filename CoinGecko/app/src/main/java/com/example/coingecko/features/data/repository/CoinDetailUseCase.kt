package com.example.coingecko.features.data.repository

import com.example.coingecko.features.domain.model.CoinDetail
import com.example.coingecko.features.domain.repository.CoinRepository
import com.example.coingecko.features.util.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinDetailUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(id: String): Flow<ResponseState<CoinDetail>> = flow {
        try {
            emit(ResponseState.Loading<CoinDetail>())
            val coin = coinRepository.getCoinById(id).toCoinDetail()
            emit(ResponseState.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(
                ResponseState.Error<CoinDetail>(
                    e.localizedMessage ?: "An Unexpected Error Ocurred"
                )
            )
        } catch (e: IOException) {
            emit(ResponseState.Error<CoinDetail>(message = "Error Ocurred"))
        }
    }
}