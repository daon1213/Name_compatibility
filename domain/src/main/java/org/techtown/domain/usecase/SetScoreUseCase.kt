package org.techtown.domain.usecase

import org.techtown.domain.model.DomainScore
import org.techtown.domain.repository.MainRepository
import javax.inject.Inject

class SetScoreUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    fun execute(score : DomainScore) = mainRepository.setScore(score)
}