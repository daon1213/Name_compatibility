package org.techtown.domain.usecase

import org.techtown.domain.repository.MainRepository
import javax.inject.Inject

class GetStatisticsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    fun execute() = mainRepository.getStatistics()
}