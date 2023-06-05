package com.example.finalproject.view.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ItemDestinasiBinding

class HomeAdapter(private val itemList : List<ItemDestinasi>) : RecyclerView.Adapter<HomeAdapter.ItemViewHolder>(){
    class ItemViewHolder(private val binding: ItemDestinasiBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : ItemDestinasi){
            binding.ivDestinasi.setImageResource(item.img)
            binding.tvDestinasi.text = item.destinasi
            binding.tvJenisPesawat.text = item.jenisPesawat
            binding.tvTanggal.text = item.mulaiDari
            binding.tvMulaiDari.text = item.mulaiDari
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDestinasiBinding.inflate(inflater,parent,false)
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