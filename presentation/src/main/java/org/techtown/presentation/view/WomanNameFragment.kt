package org.techtown.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import org.techtown.presentation.R
import org.techtown.presentation.base.BaseFragment
import org.techtown.presentation.databinding.FragmentMainBinding
import org.techtown.presentation.databinding.FragmentWomanNameBinding
import org.techtown.presentation.viewmodel.MainViewModel


class WomanNameFragment : BaseFragment<FragmentWomanNameBinding>(R.layout.fragment_woman_name) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this

    }

    fun nextBtnClick(view: View){
        mainViewModel.womanNameResult = binding.nameEditTxt.text.toString()
        this.findNavController().navigate(R.id.action_womanNameFragment2_to_manNameFragment)
    }

}