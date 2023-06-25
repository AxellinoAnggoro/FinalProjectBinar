//package com.example.finalproject.view.ui.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.finalproject.databinding.ItemHasilPencarianBinding
//import com.example.finalproject.model.ItemHasilPencarian
//
//class PencarianAdapter(private val itemList : List<ItemHasilPencarian>) : RecyclerView.Adapter<PencarianAdapter.ItemViewHolder>(){
//
//    class ItemViewHolder(private val binding : ItemHasilPencarianBinding) : RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(item : ItemHasilPencarian){
//            binding.tvJamBerangkat.text = item.jamBerangkat
//            binding.tvInisial.text = item.inisial
//            binding.tvEstimasiWaktu.text = item.estimasiWaktu
//            binding.tvJamTiba.text = item.jamTiba
//            binding.tvInisialDua.text = item.inisial2
//            binding.tvHarga.text = item.harga
//            binding.tvClassPesawat.text = item.classPesawat
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = ItemHasilPencarianBinding.inflate(inflater,parent,false)
//        return ItemViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int {
//        return itemList.size
//    }
//
//    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        val item = itemList[position]
//        holder.bind(item)
//    }
//
//}