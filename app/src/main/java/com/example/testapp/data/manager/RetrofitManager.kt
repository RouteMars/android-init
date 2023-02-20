package com.example.testapp.data.manager

import com.example.testapp.common.Info
import com.example.testapp.data.repository.TestRepository
import com.example.testapp.data.service.TestService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitManager {

    @Provides
    @Singleton
    @OptIn(ExperimentalSerializationApi::class)
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Info.BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    fun provideTestService(retrofit: Retrofit): TestService {
        return retrofit.create(TestService::class.java)
    }

    @Provides
    fun provideTestRepository(api: TestService) = TestRepository(api)
}