package com.example.finalproject.view.ui.bottomsheetfilterharga

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentBottomSheetFilterHargaBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomSheetFilterHargaFragment : BottomSheetDialogFragment() {

    companion object {
       val bottomTag : String = "filterHarga"
    }
    lateinit var binding : FragmentBottomSheetFilterHargaBinding
    private lateinit var filterClass : String
    private val viewModel : BottomSheetFilterHargaViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetFilterHargaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnClose.setOnClickListener {
                dismiss()
            }
            cv1.setOnClickListener { selectedFilter(0) }
            cv2.setOnClickListener { selectedFilter(1) }
            cv3.setOnClickListener { selectedFilter(2) }
            cv4.setOnClickListener { selectedFilter(3) }
            cv5.setOnClickListener { selectedFilter(4) }
            cv6.setOnClickListener { selectedFilter(5) }

            btnSimpan.setOnClickListener {
                viewModel.setFilter(filterClass)
                dismiss()
            }
        }
    }

    private fun selectedFilter(selectIndex: Int) {
            val isSelected = listOf(
            binding.cv1,
            binding.cv2,
            binding.cv3,
            binding.cv4,
            binding.cv5,
            binding.cv6
            )
            isSelected.forEachIndexed{index, selectFilter ->
                val filterSelect = (index == selectIndex)
                val textColor = if (filterSelect){
                    R.color.white
                }else{
                    R.color.neutral05
                }
                val backgroundColorRes = if (filterSelect){
                    R.color.darkblue05
                }else{
                    R.color.white
                }
                selectFilter.setBackgroundColor(resources.getColor(backgroundColorRes))
                selectFilter.findViewById<MaterialTextView>(getFilterTextView(index)).setTextColor(resources.getColor(textColor))
                selectFilter.findViewById<MaterialTextView>(getFilterTypeTextView(index)).setTextColor(resources.getColor(textColor))
                selectFilter.findViewById<ShapeableImageView>(getFilterSuccess(index)).visibility = if(filterSelect){
                    View.VISIBLE
                }else{
                    View.GONE
                }
                if(filterSelect){
                    filterClass = selectFilter.findViewById<MaterialTextView>(getFilterTypeTextView(index)).text.toString()
                }
            }

    }

    private fun getFilterTypeTextView(index: Int): Int {
        return when(index){
            0 -> R.id.tvHargaTermurah
            1 -> R.id.tvTerpendek
            2 -> R.id.tvPalingAwal
            3 -> R.id.tvPalingAkhir
            4 -> R.id.tvKedatanganAwal
            5 -> R.id.tvKedatanganAkhir
            else -> throw IllegalArgumentException("Invalid Index")
        }

    }

    private fun getFilterSuccess(index: Int): Int {
        return when(index){
            0 -> R.id.ivChecklist1
            1 -> R.id.ivChecklist2
            2 -> R.id.ivChecklist3
            3 -> R.id.ivChecklist4
            4 -> R.id.ivChecklist5
            5 -> R.id.ivChecklist6
            else -> throw IllegalArgumentException("Invalid index")
        }
    }

    private fun getFilterTextView(index: Int): Int {
        return when(index){
            0 -> R.id.tvHarga
            1 -> R.id.tvDurasi
            2 -> R.id.tvKeberangkatan
            3 -> R.id.tvKeberangkatan2
            4 -> R.id.tvKedatangan
            5 -> R.id.tvKedatangan2
            else -> throw IllegalArgumentException("Invalid index")
        }
    }

}