//package com.example.finalproject.view.ui.hasilpencarian
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.finalproject.databinding.ItemHasilPencarianBinding
//import com.example.finalproject.model.flight.FlightsResponse
//
//class PencarianAdapter(private val listFlight : List<FlightsResponse>) : RecyclerView.Adapter<PencarianAdapter.ViewHolder>() {
//    class ViewHolder(var binding: ItemHasilPencarianBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bindFlight(itemFlight : FlightsResponse){
//            with(itemView){
//                binding.apply {
//                    binding.tvJamBerangkat.text = itemFlight.data
//                }
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = ItemHasilPencarianBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//    }
//
//    override fun getItemCount(): Int {
//        return listFlight.size
//    }
//
//}