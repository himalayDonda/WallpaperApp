package com.example.wallpaperapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaperapp.base.BaseApplication
import com.example.wallpaperapp.databinding.ListItemSearchBinding

class RecentSearchAdapter(var list: ArrayList<String>): RecyclerView.Adapter<RecentSearchAdapter.viewHolder>() {

    inner class viewHolder(var binding: ListItemSearchBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(data: String) {
            binding.txtSearchitem.text = data

            binding.txtSearchitem.setOnClickListener{
                mAction?.search(data)
            }
        }
    }

    interface action{
        fun search(str: String)
    }

    var mAction: action? = null

    fun setListener(action: action){
        this.mAction = action
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var view = ListItemSearchBinding.inflate(LayoutInflater.from(BaseApplication.getApplicationContext()), parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}