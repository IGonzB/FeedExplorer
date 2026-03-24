package com.example.feedexplorer.data.di

import com.example.feedexplorer.data.ProfessionalApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideKotlinSerialization(): Json {
        return Json {
            ignoreUnknownKeys = true // Production habit: Don't crash if API adds new fields
            coerceInputValues = true
            isLenient = true
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(json: Json): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl("https://mocki.io/")
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideProfessionalApi(retrofit: Retrofit): ProfessionalApi {
        return retrofit.create(ProfessionalApi::class.java)
    }
}