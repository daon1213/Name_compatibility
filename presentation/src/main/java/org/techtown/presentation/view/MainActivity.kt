package org.techtown.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.pss.barlibrary.CustomBar.Companion.setTransparentBar
import dagger.hilt.android.AndroidEntryPoint
import org.techtown.presentation.R
import org.techtown.presentation.base.BaseActivity
import org.techtown.presentation.databinding.ActivityMainBinding
import org.techtown.presentation.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel by viewModels<MainViewModel>()
    override fun init() {
        setTransparentBar(this)
    }
}