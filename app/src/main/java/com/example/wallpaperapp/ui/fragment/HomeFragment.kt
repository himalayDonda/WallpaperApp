package com.example.wallpaperapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.wallpaperapp.R
import com.example.wallpaperapp.adapter.ViewPagerAdapter
import com.example.wallpaperapp.base.BaseFragment
import com.example.wallpaperapp.databinding.FragmentHomeBinding
import com.example.wallpaperapp.ui.activity.SearchActivity
import com.example.wallpaperapp.ui.activity.WallpapersExtended
import com.example.wallpaperapp.utils.openActivity
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseFragment(), View.OnClickListener {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewPager()
        clicks()
    }

    private fun clicks() {
        binding.searchWallpapers.setOnClickListener(this)
        binding.btnShowAll.setOnClickListener(this)
    }

    private fun setViewPager() {
        var fragment = WallpaperFragment()
        var fragment2 = WallpaperFragment()

        val fragmentList = ArrayList<BaseFragment>()
        fragmentList.add(fragment)
        fragmentList.add(fragment2)

        val adapter = ViewPagerAdapter(
            childFragmentManager, lifecycle,
            fragmentList
        )
        binding.viewpager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->
            tab.text = when (position) {
                0 -> {
                    getString(R.string.tab_1)
                }
                1 -> {
                    getString(R.string.tab_2)
                }
                2 -> {
                    getString(R.string.tab_3)
                }
                else -> getString(R.string.tab_1)
            }

            resources.getStringArray(R.array.tabs)[position]
        }.attach()

    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.searchWallpapers -> {
                openActivity(SearchActivity::class.java)
            }
            binding.btnShowAll -> {
                openActivity(WallpapersExtended::class.java)
            }
        }
    }

}