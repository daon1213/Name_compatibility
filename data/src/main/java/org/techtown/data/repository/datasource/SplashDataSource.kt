package org.techtown.data.repository.datasource

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

interface SplashDataSource {
    fun checkAppVersion() : Task<DataSnapshot>
}