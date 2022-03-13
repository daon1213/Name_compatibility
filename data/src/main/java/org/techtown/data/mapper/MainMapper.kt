package org.techtown.data.mapper

import org.techtown.data.remote.model.DataLoveResponse
import org.techtown.data.remote.model.DataScore
import org.techtown.domain.model.DomainLoveResponse
import org.techtown.domain.model.DomainScore

object MainMapper {

    fun loveMapper(
        dataResponse: DataLoveResponse?
    ): DomainLoveResponse? {
        return if (dataResponse != null) {
            DomainLoveResponse(
                fname = dataResponse.fname,
                percentage = dataResponse.percentage,
                result = dataResponse.result,
                sname = dataResponse.sname
            )
        } else dataResponse
    }

    fun scoreMapper(
        domainResponse : DomainScore
    ) : DataScore {
        return DataScore(
            man = domainResponse.man,
            woman = domainResponse.woman,
            percentage = domainResponse.percentage,
            date = domainResponse.date
        )
    }
}