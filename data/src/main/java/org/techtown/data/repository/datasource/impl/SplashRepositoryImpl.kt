package org.techtown.data.repository.datasource.impl

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import org.techtown.data.repository.datasource.SplashDataSource
import org.techtown.domain.repository.SplashRepository
import javax.inject.Inject

class SplashRepositoryImpl @Inject constructor(
    private val splashDataSource : SplashDataSource
) : SplashRepository {
    override fun checkAppVersion(): Task<DataSnapshot> {
        return splashDataSource.checkAppVersion()
    }
}