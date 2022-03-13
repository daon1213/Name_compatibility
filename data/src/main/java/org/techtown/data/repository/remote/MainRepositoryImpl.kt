package org.techtown.data.repository.remote

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.QuerySnapshot
import org.techtown.data.mapper.MainMapper
import org.techtown.data.repository.datasource.MainDataSource
import org.techtown.domain.model.DomainLoveResponse
import org.techtown.domain.model.DomainScore
import org.techtown.domain.repository.MainRepository
import org.techtown.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainDataSource: MainDataSource
    ) : MainRepository {

    override suspend fun checkLoveCalculator(remoteErrorEmitter: RemoteErrorEmitter, host : String, key : String, mName : String, wName : String): DomainLoveResponse? {
        return MainMapper.loveMapper(mainDataSource.checkLoveCalculator(remoteErrorEmitter = remoteErrorEmitter, host = host, key = key, mName = mName, wName = wName))
    }

    override fun getStatistics(): Task<DataSnapshot> {
        return mainDataSource.getStatistics()
    }

    override fun setStatistics(plusResult: Int): Task<Void> {
        return mainDataSource.setStatistics(plusResult)
    }

    override fun setScore(score: DomainScore): Task<Void> {
        return mainDataSource.setScore(MainMapper.scoreMapper(score))
    }

    override fun getScore(): Task<QuerySnapshot> {
        return mainDataSource.getScore()
    }
}