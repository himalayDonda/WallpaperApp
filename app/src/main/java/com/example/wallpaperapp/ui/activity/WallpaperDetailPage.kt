package com.example.wallpaperapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.wallpaperapp.R
import com.example.wallpaperapp.databinding.ActivityWallpaperDetailPageBinding
import com.example.wallpaperapp.databinding.ActivityWallpapersExtendedBinding
import com.example.wallpaperapp.utils.Utils

class WallpaperDetailPage : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityWallpaperDetailPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_wallpaper_detail_page)
        clicks()
    }

    private fun clicks() {
        binding.imgBack.setOnClickListener(this)
        binding.imgShare.setOnClickListener(this)
        binding.imgDownload.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.imgBack ->{
                onBackPressedDispatcher.onBackPressed()
            }
            binding.imgShare ->{
                Utils.shareApp()
            }
            binding.imgDownload ->{

            }
        }
    }
}