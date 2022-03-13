package org.techtown.presentation.view

import androidx.activity.viewModels
import com.pss.barlibrary.CustomBar
import dagger.hilt.android.AndroidEntryPoint
import org.techtown.presentation.R
import org.techtown.presentation.base.BaseActivity
import org.techtown.presentation.databinding.ActivitySplashBinding
import org.techtown.presentation.viewmodel.SplashViewModel
import org.techtown.presentation.widget.extension.startActivityWithFinish

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    private val splashViewModel by viewModels<SplashViewModel>()
    private val appVersion = "1.0.0"

    override fun init() {
        CustomBar.setTransparentBar(this)
        this.splashViewModel.checkAppverison()
            .addOnSuccessListener {
                if (appVersion == it.value){
                    this.startActivityWithFinish(this, MainActivity::class.java)
                }else longShowToast("앱 버전이 다릅니다!")
            }

            .addOnFailureListener {
                shortShowToast("오류가 발생했습니다. 오류코드 - ${it.message}")
            }
    }

}