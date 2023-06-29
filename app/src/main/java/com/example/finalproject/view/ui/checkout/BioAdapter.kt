package com.example.finalproject.view.ui.checkout

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ItemJenisPenumpangBinding
import com.example.finalproject.model.passenger.Penumpang

class BioAdapter (private val listPassenger : List<Penumpang>) : RecyclerView.Adapter<BioAdapter.ViewHolder>(){

    private var listener : OnItemClickListener? = null

    fun setOnItemClickListener(listener : OnItemClickListener){
        this.listener = listener
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    inner class ViewHolder(private val binding : ItemJenisPenumpangBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindPenumpang(it: Penumpang){
            binding.tvJenisPenumpang.text = it.penumpang
            binding.cvItemJenisPenumpang.setOnClickListener {
                listener?.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemJenisPenumpangBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPassenger.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPenumpang(listPassenger[position])
    }
}