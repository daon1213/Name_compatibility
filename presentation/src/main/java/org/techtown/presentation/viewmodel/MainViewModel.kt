package org.techtown.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.techtown.domain.model.DomainLoveResponse
import org.techtown.domain.model.DomainScore
import org.techtown.domain.usecase.*
import org.techtown.domain.utils.ErrorType
import org.techtown.domain.utils.RemoteErrorEmitter
import org.techtown.domain.utils.ScreenState
import org.techtown.presentation.widget.utils.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val checkLoveCalculatorUseCase: CheckLoveCalculatorUseCase,
    private val setStatisticUseCase: SetStatisticUseCase,
    private val getStatisticsUseCase: GetStatisticsUseCase,
    private val setScoreUseCase : SetScoreUseCase,
    private val getScoreUseCase: GetScoreUseCase
): ViewModel(), RemoteErrorEmitter {

    val apiCallEvent: LiveData<ScreenState> get() = _apiCallEvent
    private var _apiCallEvent = SingleLiveEvent<ScreenState>()

    val getStatisticsEvent: LiveData<Int> get() = _getStatisticsEvent
    private var _getStatisticsEvent = SingleLiveEvent<Int>()

    val getScoreEvent: LiveData<Int> get() = _getScoreEvent
    private var _getScoreEvent = SingleLiveEvent<Int>()

    var apiCallResult = DomainLoveResponse("", "", 0, "")
    var apiErrorType = ErrorType.UNKNOWN
    var apiErrorMessage = "none"
    var manNameResult = "man"
    var womanNameResult = "woman"
    val scoreList = arrayListOf<DomainScore>()

    fun checkLoveCalculator(host : String, key : String, mName : String, wName : String) = viewModelScope.launch {
        checkLoveCalculatorUseCase.execute(this@MainViewModel, host, key, mName, wName).let {
            response -> //반환 값이 null이 아니고 잘 받아져 왔을 때
            if (response != null){
                apiCallResult = response
                _apiCallEvent.postValue(ScreenState.LOADING)
            }
            //반환 값이 null일 때
            else _apiCallEvent.postValue(ScreenState.ERROR)
        }
    }

    fun setStatistics(plusValue : Int) = setStatisticUseCase.execute(plusValue)

    fun getStatistics() = getStatisticsUseCase.execute()

    fun getStatisticsDisplay() = getStatisticsUseCase.execute()
        .addOnSuccessListener {
            _getStatisticsEvent.postValue(it.value.toString().toInt())
        }

    fun getScore() = getScoreUseCase.execute()
        .addOnSuccessListener { snapshot ->
            scoreList.clear()
            for (item in snapshot.documents){
                item.toObject(DomainScore::class.java).let {
                    scoreList.add(it!!)
                }
            }
            _getScoreEvent.call()
        }

    fun setScore(man : String, woman : String, percentage : Int, date : String){
        setScoreUseCase.execute(DomainScore(man, woman, percentage, date))
    }

    override fun onError(msg: String) {
        apiErrorMessage = msg
    }

    override fun onError(errorType: ErrorType) {
        apiErrorType = errorType
    }

}

