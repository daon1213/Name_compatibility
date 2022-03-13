package org.techtown.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.pss.library.CountNumberEvent.Companion.countNumber
import org.techtown.presentation.R
import org.techtown.presentation.adapter.ScoreRecyclerViewAdapter
import org.techtown.presentation.base.BaseFragment
import org.techtown.presentation.databinding.FragmentMainBinding
import org.techtown.presentation.databinding.FragmentManNameBinding
import org.techtown.presentation.viewmodel.MainViewModel
import org.techtown.presentation.widget.extension.showVertical

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        observeViewModel()
        mainViewModel.getStatisticsDisplay()
        mainViewModel.getScore()
    }

    fun startBtnClick(view: View){
        this.findNavController().navigate(R.id.action_mainFragment_to_womanNameFragment2)
    }

    private fun observeViewModel(){
        mainViewModel.getStatisticsEvent.observe(this){
            countNumber(0, it, binding.statistics, 3000)
        }

        mainViewModel.getScoreEvent.observe(this){
            initRecyclerView()
        }
    }

    private fun initRecyclerView(){
        binding.scoreRecyclerView.adapter = ScoreRecyclerViewAdapter(mainViewModel)
        binding.scoreRecyclerView.showVertical(requireContext())
    }
}
