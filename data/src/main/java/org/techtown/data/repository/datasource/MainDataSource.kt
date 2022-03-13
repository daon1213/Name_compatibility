package org.techtown.data.repository.datasource

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.QuerySnapshot
import org.techtown.data.remote.model.DataLoveResponse
import org.techtown.data.remote.model.DataScore
import org.techtown.domain.utils.RemoteErrorEmitter

interface MainDataSource {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String,
        wName: String
    ): DataLoveResponse?

    // 통계 가져오기
    fun getStatistics(): Task<DataSnapshot>

    // 통계 저장하기
    fun setStatistics(plusResult: Int): Task<Void>

    // 전적 저장하기
    fun setScore(score: DataScore): Task<Void>

    // 전적 가져오기
   fun getScore(): Task<QuerySnapshot>
}