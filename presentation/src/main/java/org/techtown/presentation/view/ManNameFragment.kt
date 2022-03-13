package org.techtown.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import org.techtown.domain.utils.ErrorType
import org.techtown.domain.utils.ScreenState
import org.techtown.presentation.R
import org.techtown.presentation.base.BaseFragment
import org.techtown.presentation.databinding.FragmentMainBinding
import org.techtown.presentation.databinding.FragmentManNameBinding
import org.techtown.presentation.viewmodel.MainViewModel

class ManNameFragment : BaseFragment<FragmentManNameBinding>(R.layout.fragment_man_name) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        observeViewModel()
    }

    fun nextBtnClick(view: View){
        binding.loadingBar.visibility = View.VISIBLE
        mainViewModel.checkLoveCalculator(
            "love-calculator.p.rapidapi.com",
            "2500b69385mshf5844037a417b97p178d2fjsn8ca05af45583",
            binding.nameEditTxt.text.toString(),
            mainViewModel.womanNameResult
        )
    }

    private fun observeViewModel(){
        binding.loadingBar.visibility = View.INVISIBLE
        mainViewModel.apiCallEvent.observe(this){
            when(it){
                ScreenState.LOADING -> this.findNavController().navigate(R.id.action_manNameFragment_to_resultFragment)
                ScreenState.ERROR -> toastErrorMsg()
                else -> shortShowToast("알 수없는 오류가 발생했습니다")
            }
        }
    }

    private fun toastErrorMsg(){
        when(mainViewModel.apiErrorType){
            ErrorType.NETWORK -> longShowToast("네트워크 오류가 발생했습니다")
            ErrorType.SESSION_EXPIRED -> longShowToast("세션이 만료되었습니다")
            ErrorType.TIMEOUT -> longShowToast("호출 시간이 초과되었습니다")
            ErrorType.UNKNOWN -> longShowToast("예기치 못한 오류가 발생하였습니다")
        }
    }
}