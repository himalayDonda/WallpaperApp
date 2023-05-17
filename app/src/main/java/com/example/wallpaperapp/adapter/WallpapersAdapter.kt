package com.example.wallpaperapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaperapp.base.BaseApplication
import com.example.wallpaperapp.databinding.ListItemWallpaperBinding
import com.example.wallpaperapp.model.WallpaperModel
import com.example.wallpaperapp.utils.Utils

class WallpapersAdapter(): ListAdapter<WallpaperModel, WallpapersAdapter.viewh>(DIFFCALLBACK) {

    inner class viewh(var listItemWallpaperBinding: ListItemWallpaperBinding) : RecyclerView.ViewHolder(listItemWallpaperBinding.root)

    interface action{
        fun openWallpaper(model: WallpaperModel)
    }

    var mAction: action? = null

    fun setListener(action: action){
        this.mAction = action
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewh {
        val v = ListItemWallpaperBinding.inflate(LayoutInflater.from(BaseApplication.getApplicationContext()), parent, false)
        return viewh(v)
    }

    override fun onBindViewHolder(holder: viewh, position: Int) {
        holder.listItemWallpaperBinding.cardMonth.updateLayoutParams<RelativeLayout.LayoutParams> {
            if (position%2==0){
                setMargins(Utils.dpTopPx(15), 0, Utils.dpTopPx(0f), Utils.dpTopPx(15))
            }else {
                setMargins(Utils.dpTopPx(0f), 0, Utils.dpTopPx(15), Utils.dpTopPx(15))
            }
        }

        holder.listItemWallpaperBinding.cardMonth.setOnClickListener {
            mAction?.openWallpaper(currentList[holder.adapterPosition])
        }
    }

    object DIFFCALLBACK : DiffUtil.ItemCallback<WallpaperModel>() {
        override fun areItemsTheSame(oldItem: WallpaperModel, newItem: WallpaperModel): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: WallpaperModel, newItem: WallpaperModel): Boolean {
            return oldItem == newItem
        }
    }


}