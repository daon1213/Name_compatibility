package org.techtown.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.QuerySnapshot
import org.techtown.domain.model.DomainLoveResponse
import org.techtown.domain.model.DomainScore
import org.techtown.domain.utils.RemoteErrorEmitter
import retrofit2.Response

interface MainRepository {
    suspend fun checkLoveCalculator(remoteErrorEmitter: RemoteErrorEmitter, host : String, key : String, mName : String, wName : String) : DomainLoveResponse?

    fun getStatistics() : Task<DataSnapshot>

    fun setStatistics(plusResult : Int) : Task<Void>

    fun setScore(score: DomainScore) : Task<Void>

    fun getScore(): Task<QuerySnapshot>
}