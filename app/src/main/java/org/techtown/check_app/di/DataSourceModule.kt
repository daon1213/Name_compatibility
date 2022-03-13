package org.techtown.check_app.di

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.techtown.data.remote.api.LoveCalculatorApi
import org.techtown.data.repository.datasource.MainDataSource
import org.techtown.data.repository.remote.MainDataSourceImpl
import org.techtown.data.repository.datasource.SplashDataSource
import org.techtown.data.repository.remote.SplashDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideMainDataSource(
        loveCalculatorApi: LoveCalculatorApi,
        firebaseRtdb : FirebaseDatabase,
        fireStore : FirebaseFirestore
    ) : MainDataSource {
        return MainDataSourceImpl(
            loveCalculatorApi,
            firebaseRtdb, fireStore
        )
    }

    @Provides
    @Singleton
    fun provideSplashDataSource(
        firebaseRtdb : FirebaseDatabase,
        fireStore : FirebaseFirestore
    ) : SplashDataSource {
        return SplashDataSourceImpl(
            firebaseRtdb = firebaseRtdb, fireStore = fireStore
        )
    }
}

