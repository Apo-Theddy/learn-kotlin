package com.example.coingecko.features.di

import com.example.coingecko.features.data.data_source.CoinGeckoApi
import com.example.coingecko.features.data.repository.CoinRepositoryImpl
import com.example.coingecko.features.domain.repository.CoinRepository
import com.example.coingecko.features.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoinGeckoModule {

    @Provides
    @Singleton
    fun provideCoinGeckoApi():CoinGeckoApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinGeckoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinGeckoRepository(api: CoinGeckoApi):CoinRepository{
        return CoinRepositoryImpl(api)
    }
}