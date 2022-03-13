package org.techtown.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.techtown.domain.usecase.CheckAppVersionUseCase
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val checkAppVersionUseCase: CheckAppVersionUseCase
): ViewModel() {

fun checkAppverison() = checkAppVersionUseCase.execute()
}