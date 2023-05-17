package com.example.wallpaperapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaperapp.R
import com.example.wallpaperapp.adapter.WallpapersAdapter
import com.example.wallpaperapp.databinding.ActivityWallpapersExtendedBinding
import com.example.wallpaperapp.model.WallpaperModel
import com.example.wallpaperapp.utils.openActivity

class WallpapersExtended : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityWallpapersExtendedBinding
    private var wallpaperAdapter: WallpapersAdapter? = null

    private var wallPaperAction = object : WallpapersAdapter.action{
        override fun openWallpaper(model: WallpaperModel) {
            openActivity(WallpaperDetailPage::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_wallpapers_extended)

        setRec()
        clicks()
    }

    private fun clicks() {
        binding.toolbar.imgBack.setOnClickListener(this)
    }

    private fun setRec() {
        var wallPaerList = arrayListOf<WallpaperModel>(WallpaperModel("", ""), WallpaperModel(), WallpaperModel(),  WallpaperModel(),  WallpaperModel(),  WallpaperModel(),  WallpaperModel(),  WallpaperModel(),  WallpaperModel(),  WallpaperModel())
        wallpaperAdapter = WallpapersAdapter()
        wallpaperAdapter?.submitList(wallPaerList)
        wallpaperAdapter?.setListener(wallPaperAction)

        binding.recWallpapers.setHasFixedSize(true)
        binding.recWallpapers.layoutManager = GridLayoutManager(this, 2)
        binding.recWallpapers.adapter = wallpaperAdapter
    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.toolbar.imgBack -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }

}