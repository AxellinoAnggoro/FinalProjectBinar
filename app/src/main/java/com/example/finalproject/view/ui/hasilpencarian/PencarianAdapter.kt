package com.example.finalproject.view.ui.hasilpencarian

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ItemHasilPencarianBinding
import com.example.finalproject.model.flight.DataFlight
import java.text.SimpleDateFormat
import java.util.*

class PencarianAdapter(
    private var listFlight: List<DataFlight?>,
//    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<PencarianAdapter.ViewHolder>() {

//    interface OnItemClickListener{
//
//    }

    class ViewHolder(var binding: ItemHasilPencarianBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindFlight(itemFlight: DataFlight) {
            with(itemView) {
                binding.apply {
                    val departureTime = itemFlight.departureTime
                    val setDeparture = getHourFromDateTime(departureTime)
                    val arrivalTime = itemFlight.arrivalTime
                    val setArrival = getHourFromDateTime(arrivalTime)

//                    tvJamBerangkat.text = itemFlight.departureTime
//                    tvJamTiba.text = itemFlight.arrivalTime
                    tvJamBerangkat.text = setDeparture
                    tvJamTiba.text = setArrival
                    tvInisial.text = itemFlight.departureAirport.city
                    tvInisialDua.text = itemFlight.arrivalAirport.city
                    tvHarga.text = itemFlight.economyClassPrice.toString()
                    tvClassPesawat.text = itemFlight.airline.airlineName
                }
            }
        }

        private fun getHourFromDateTime(dateTime: String): String {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)
            val outputFormat = SimpleDateFormat("HH", Locale.US)

            return try {
                val date = inputFormat.parse(dateTime)
                outputFormat.format(date!!)
            } catch (e: Exception) {
                e.printStackTrace()
                ""
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            ItemHasilPencarianBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindFlight(listFlight[position]!!)
    }

    override fun getItemCount(): Int {
        return listFlight.size
    }

    fun updateData(newList: List<DataFlight>) {
        listFlight = newList
        notifyDataSetChanged()
    }
}