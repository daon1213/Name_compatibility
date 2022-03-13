package org.techtown.domain.usecase

import org.techtown.domain.repository.MainRepository
import javax.inject.Inject

class SetStatisticUseCase@Inject constructor(
    private val mainRepository: MainRepository
) {
    fun execute(plusValue : Int) = mainRepository.setStatistics(plusValue)
}