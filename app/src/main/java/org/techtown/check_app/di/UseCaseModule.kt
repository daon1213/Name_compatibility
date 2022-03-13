package org.techtown.check_app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.techtown.domain.repository.MainRepository
import org.techtown.domain.repository.SplashRepository
import org.techtown.domain.usecase.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideCheckLoveCalculatorUseCase(repository: MainRepository) = CheckLoveCalculatorUseCase(repository)

    @Provides
    @Singleton
    fun provideCheckAppVersionUseCase(repository: SplashRepository) = CheckAppVersionUseCase(repository)

    @Provides
    @Singleton
    fun provideGetStatisticsUseCase(repository: MainRepository) = GetStatisticsUseCase(repository)

    @Provides
    @Singleton
    fun provideSetStatisticsUseCase(repository: MainRepository) = SetStatisticUseCase(repository)

    @Provides
    @Singleton
    fun provideSetScoreUseCase(repository: MainRepository) = SetScoreUseCase(repository)

    @Provides
    @Singleton
    fun provideGetScoreUseCase(repository: MainRepository) = GetScoreUseCase(repository)
}