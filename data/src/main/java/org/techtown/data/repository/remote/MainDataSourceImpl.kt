package org.techtown.data.repository.remote

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import org.techtown.data.remote.api.LoveCalculatorApi
import org.techtown.data.remote.model.DataLoveResponse
import org.techtown.data.remote.model.DataScore
import org.techtown.data.repository.datasource.MainDataSource
import org.techtown.data.utils.BaseDataSource
import org.techtown.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class MainDataSourceImpl @Inject constructor(
    private val loveCalculatorApi: LoveCalculatorApi,
    private val firebaseRtdb: FirebaseDatabase,
    private val fireStore: FirebaseFirestore
) : BaseDataSource(), MainDataSource {

    override suspend fun checkLoveCalculator(remoteErrorEmitter: RemoteErrorEmitter, host : String, key : String, mName : String, wName : String): DataLoveResponse? {
        return safeApiCall(remoteErrorEmitter){
            loveCalculatorApi.getPercentage(host = host, key = key, fName = wName, sName = mName)
        }?.body()
    }

    override fun getStatistics(): Task<DataSnapshot> {
        return firebaseRtdb.reference.child("statistics").get()
    }

    override fun setStatistics(plusResult: Int): Task<Void> {
        return firebaseRtdb.reference.child("statistics").setValue(plusResult)
    }

    override fun setScore(score: DataScore): Task<Void> {
        return fireStore.collection("score").document().set(score)
    }

    override fun getScore(): Task<QuerySnapshot> {
        return fireStore.collection("score").orderBy("date", Query.Direction.DESCENDING).get()
    }
}