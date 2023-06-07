package com.example.finalproject.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ItemJadwalBinding
import com.example.finalproject.model.ItemJadwal

class JadwalAdapter(private val itemList : List<ItemJadwal>) : RecyclerView.Adapter<JadwalAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val binding : ItemJadwalBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(item : ItemJadwal){
            binding.tvHari.text = item.hari
            binding.tvTanggal.text = item.tanggal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemJadwalBinding.inflate(inflater,parent,false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }


}