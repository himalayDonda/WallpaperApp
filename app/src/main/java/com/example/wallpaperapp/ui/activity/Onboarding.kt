package com.example.wallpaperapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import com.example.wallpaperapp.R
import com.example.wallpaperapp.databinding.ActivityOnboardingBinding
import com.example.wallpaperapp.utils.openActivity

class Onboarding : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding)
        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_LOW_PROFILE or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,  WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        binding.swipeLay.setOnClickListener {
            startMainActivity()
        }
    }

    private fun startMainActivity(){
        openActivity(MainActivity::class.java)
        finish()
    }

}