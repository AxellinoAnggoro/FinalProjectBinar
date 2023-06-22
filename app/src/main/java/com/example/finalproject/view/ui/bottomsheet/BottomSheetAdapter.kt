package com.example.finalproject.view.ui.bottomsheet

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ItemAsalTujuanBinding
import com.example.finalproject.model.airports.Airport

class BottomSheetAdapter(
    private val listCity: List<Airport?>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<BottomSheetAdapter.ViewHolder>() {

    class ViewHolder(var binding: ItemAsalTujuanBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindCity(itemCity: Airport?) {
            with(itemView) {
                binding.tv.text = itemCity?.city ?: ""
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemAsalTujuanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCity.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCity(listCity[position]!!)
        holder.itemView.setOnClickListener {
            val city = listCity[position]?.city
            city?.let { onItemClick(it) }
        }
    }
}