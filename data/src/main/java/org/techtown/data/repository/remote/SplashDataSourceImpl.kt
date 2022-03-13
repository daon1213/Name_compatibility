package org.techtown.data.repository.remote

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import org.techtown.data.repository.datasource.SplashDataSource
import javax.inject.Inject

class SplashDataSourceImpl @Inject constructor(
    private val firebaseRtdb: FirebaseDatabase,
    private val fireStore: FirebaseFirestore
) : SplashDataSource {
    override fun checkAppVersion() : Task<DataSnapshot>{
        return firebaseRtdb.reference.child("version").get()
    }
}