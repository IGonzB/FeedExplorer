package com.example.feedexplorer.data.di

import com.example.feedexplorer.data.impl.ProfessionalRepositoryImpl
import com.example.feedexplorer.domain.data.ProfessionalRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindProfessionalRepository(
        repositoryImpl: ProfessionalRepositoryImpl
    ): ProfessionalRepository
}