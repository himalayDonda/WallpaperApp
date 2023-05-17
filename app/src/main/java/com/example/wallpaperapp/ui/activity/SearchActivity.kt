package com.example.wallpaperapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaperapp.R
import com.example.wallpaperapp.adapter.RecentSearchAdapter
import com.example.wallpaperapp.adapter.WallpapersAdapter
import com.example.wallpaperapp.databinding.ActivitySearchBinding
import com.example.wallpaperapp.databinding.SearchBarBinding
import com.example.wallpaperapp.model.WallpaperModel
import com.example.wallpaperapp.utils.openActivity
import com.example.wallpaperapp.utils.showToast
import com.google.android.flexbox.FlexboxLayoutManager

class SearchActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySearchBinding
    private lateinit var searchBinding: SearchBarBinding
    private var wallpaperAdapter: WallpapersAdapter? = null
    private var searchAdapter: RecentSearchAdapter? = null

    private var searchAction = object : RecentSearchAdapter.action{
        override fun search(str: String) {
            searchBinding.edSearch.setText(str)
        }
    }

    private var wallPaperAction = object : WallpapersAdapter.action{
        override fun openWallpaper(model: WallpaperModel) {
            openActivity(WallpapersExtended::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        searchBinding = binding.searchLay

        setRec()
        clicks()
    }

    private fun setRec() {
        searchAdapter = RecentSearchAdapter(arrayListOf("One", "teo", "theee", "four", "fivee", "six"))
        searchAdapter?.setListener(searchAction)
        var flexBoxManager = FlexboxLayoutManager(this)
        binding.recSearcHistory.setHasFixedSize(true)
        binding.recSearcHistory.layoutManager = flexBoxManager
        binding.recSearcHistory.adapter = searchAdapter

        var wallPaerList = arrayListOf<WallpaperModel>(WallpaperModel("", ""), WallpaperModel(), WallpaperModel(),  WallpaperModel(),  WallpaperModel(),  WallpaperModel(),  WallpaperModel(),  WallpaperModel(),  WallpaperModel(),  WallpaperModel())
        wallpaperAdapter = WallpapersAdapter()
        wallpaperAdapter?.submitList(wallPaerList)
        wallpaperAdapter?.setListener(wallPaperAction)

        binding.recResult.setHasFixedSize(true)
        binding.recResult.layoutManager = GridLayoutManager(this, 2)
        binding.recResult.adapter = wallpaperAdapter
    }

    private fun clicks() {
        searchBinding.imgBack.setOnClickListener(this)
        searchBinding.imgClose.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            searchBinding.imgBack -> {
                onBackPressedDispatcher.onBackPressed()
            }
            searchBinding.imgClose -> {
                searchBinding.edSearch.text = null
            }
        }
    }
}