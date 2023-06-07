package com.example.finalproject.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ItemNotifikasiBinding
import com.example.finalproject.model.ItemNotif

class NotifAdapter(private val itemList : List<ItemNotif>) : RecyclerView.Adapter<NotifAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val binding : ItemNotifikasiBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item : ItemNotif){
            binding.ivNotif.setImageResource(item.img)
            binding.tvPromosi.text = item.promosi
            binding.tvDapatkanPotongan.text = item.dapatkanPotongan
            binding.tvSyaratDanKetentuan.text = item.syaratDanKetentuan
            binding.tvTglPromosi.text = item.tgl
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNotifikasiBinding.inflate(inflater,parent,false)
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