package com.example.finalproject.view.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ItemRiwayatPesananBinding
import com.example.finalproject.model.ItemHistory

class HistoryAdapter(private val itemList: List<ItemHistory>):RecyclerView.Adapter<HistoryAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val binding : ItemRiwayatPesananBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : ItemHistory){
            binding.apply {
                tvAsalPenerbangan.text = item.departure
                tvTanggalBerangkat.text = item.tglDeparture
                tvJamBerangkat.text = item.jamDeparture
                tvDurasiPenerbangan.text = item.estimasi
                tvTujuanPenerbangan.text = item.tujuan
                tvTanggalDatang.text = item.tglTujuan
                tvJamDatang.text = item.jamTujuan
                tvInputBookCode.text = item.bookedCode
                tvInputClass.text = item.inputClass
                tvPrice.text = item.harga
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRiwayatPesananBinding.inflate(inflater,parent,false)
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