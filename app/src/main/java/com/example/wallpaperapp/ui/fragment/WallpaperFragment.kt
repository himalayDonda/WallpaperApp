package com.example.wallpaperapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaperapp.R
import com.example.wallpaperapp.ui.activity.WallpaperDetailPage
import com.example.wallpaperapp.adapter.WallpapersAdapter
import com.example.wallpaperapp.base.BaseFragment
import com.example.wallpaperapp.databinding.FragmentWallpaperBinding
import com.example.wallpaperapp.model.WallpaperModel
import com.example.wallpaperapp.utils.openActivity

class WallpaperFragment : BaseFragment() {

    private lateinit var binding: FragmentWallpaperBinding
    private var wallpaperAdapter: WallpapersAdapter? = null

    private var wallPaperAction = object : WallpapersAdapter.action {
        override fun openWallpaper(model: WallpaperModel) {
            openActivity(WallpaperDetailPage::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wallpaper, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRec()
    }

    private fun setRec() {
        var wallPaerList = arrayListOf<WallpaperModel>(
            WallpaperModel("", ""),
            WallpaperModel(),
            WallpaperModel(),
            WallpaperModel(),
            WallpaperModel(),
            WallpaperModel(),
            WallpaperModel(),
            WallpaperModel(),
            WallpaperModel(),
            WallpaperModel()
        )
        wallpaperAdapter = WallpapersAdapter()
        wallpaperAdapter?.submitList(wallPaerList)
        wallpaperAdapter?.setListener(wallPaperAction)

        binding.recWallpapers.setHasFixedSize(true)
        binding.recWallpapers.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recWallpapers.adapter = wallpaperAdapter
    }

}