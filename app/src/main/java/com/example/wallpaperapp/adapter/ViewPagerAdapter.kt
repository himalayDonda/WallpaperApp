package com.example.wallpaperapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.wallpaperapp.base.BaseFragment

class ViewPagerAdapter(var manager: FragmentManager,
                       lifecycle: Lifecycle,
                       var list: ArrayList<BaseFragment>)
    : FragmentStateAdapter(manager, lifecycle) {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

}