package org.techtown.check_app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.techtown.data.repository.datasource.MainDataSource
import org.techtown.data.repository.remote.MainRepositoryImpl
import org.techtown.data.repository.datasource.SplashDataSource
import org.techtown.data.repository.remote.SplashRepositoryImpl
import org.techtown.domain.repository.MainRepository
import org.techtown.domain.repository.SplashRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMainRepository(
        mainDataSource : MainDataSource
    ): MainRepository {
        return MainRepositoryImpl(
            mainDataSource
        )
    }

    @Provides
    @Singleton
    fun provideSplashRepository(
        splashDataSource: SplashDataSource
    ): SplashRepository {
        return SplashRepositoryImpl(
            splashDataSource
        )
    }
}