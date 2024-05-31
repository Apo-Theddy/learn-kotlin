package com.example.freegameapp.di

import com.example.freegameapp.core.utils.Constants
import com.example.freegameapp.data.remote.FreeGameApi
import com.example.freegameapp.data.repository.FreeGameRepositoryImpl
import com.example.freegameapp.domain.repository.FreeGamesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideFreeGameApi(retrofit: Retrofit): FreeGameApi =
        retrofit.create(FreeGameApi::class.java)

    @Provides
    @Singleton
    fun provideFreeGameRepository(freeGameApi: FreeGameApi): FreeGamesRepository {
        return FreeGameRepositoryImpl(freeGameApi)
    }
}