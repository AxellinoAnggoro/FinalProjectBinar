package com.example.finalproject.view.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.databinding.FragmentHistoryBinding
import com.example.finalproject.databinding.ItemDestinasiBinding
import com.example.finalproject.model.flight.DataFlight

class HomeAdapter(private var listFav : List<DataFlight?>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>(){
    class ViewHolder(var binding: ItemDestinasiBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindFav(itemFav : DataFlight){
            with(itemView){
                binding.apply {
                    Glide.with(itemView).load(itemFav.departureAirport.imgURL).into(binding.ivDestinasi)
                    tvAsal.text = itemFav.departureAirport.city
                    tvTujuan.text = itemFav.arrivalAirport.city
                    tvJenisPesawat.text = itemFav.airline.airlineName
                    tvHarga.text = itemFav.economyClassPrice.toString()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val view = ItemDestinasiBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.bindFav(listFav[position]!!)
    }

    override fun getItemCount(): Int {
        return listFav.size
    }

    fun updateData(newList: List<DataFlight>) {
        listFav = newList
        notifyDataSetChanged()
    }
}