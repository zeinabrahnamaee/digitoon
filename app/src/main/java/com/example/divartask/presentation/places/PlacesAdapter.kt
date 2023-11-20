package com.example.divartask.presentation.places

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.divartask.data.entity.PlacesListData
import com.example.divartask.databinding.PlacesItemLayoutBinding

class PlacesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var cities: ArrayList<PlacesListData.City>?= null

    fun setData(dataList: ArrayList<PlacesListData.City>?){
        cities = dataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            ItemsViewHolder(
                PlacesItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

    override fun getItemCount(): Int = cities?.size ?:0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ItemsViewHolder -> {
                holder.onBind(cities?.get(position))
            }
        }
    }

    inner class ItemsViewHolder(val binding: PlacesItemLayoutBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {

        fun onBind(data: PlacesListData.City?) {
            binding.cityName.text =  data?.name
        }
    }
}