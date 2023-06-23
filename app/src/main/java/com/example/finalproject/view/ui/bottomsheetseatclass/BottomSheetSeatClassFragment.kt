package com.example.finalproject.view.ui.bottomsheetseatclass

import android.graphics.Color
import android.opengl.Visibility
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.findFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentBottomSheetSeatClassBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.card.MaterialCardView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomSheetSeatClassFragment : BottomSheetDialogFragment() {

    lateinit var binding : FragmentBottomSheetSeatClassBinding
    private val viewModel: BottomSheetSeatClassViewModel by viewModels()
    private lateinit var seatClassName : String

    companion object {
        val bottomTag : String = "TAGSEATCLASS"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetSeatClassBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnClose.setOnClickListener {
            dismiss()
        }
        binding.cv1.setOnClickListener{ selectedSeatClass(0)}
        binding.cv2.setOnClickListener{ selectedSeatClass(1)}
        binding.cv3.setOnClickListener{ selectedSeatClass(2)}
        binding.cv4.setOnClickListener{ selectedSeatClass(3)}

        binding.btnSimpan.setOnClickListener {
            viewModel.setSeat(seatClassName)
            dismiss()
        }
    }

    private fun selectedSeatClass(selectIndex: Int) {
        val seatClassList = listOf(
            binding.cv1,
            binding.cv2,
            binding.cv3,
            binding.cv4
        )

        seatClassList.forEachIndexed{index, seatClass ->
            val isSelected = (index == selectIndex)
            val textColor = if (isSelected){
                R.color.white
            }else{
                R.color.neutral05
            }
            val backgroundColorRes = if (isSelected){
                R.color.darkblue05
            }else{
                R.color.white
            }
            seatClass.setBackgroundColor(resources.getColor(backgroundColorRes))
            seatClass.findViewById<MaterialTextView>(getSeatClassTextView(index)).setTextColor(resources.getColor(textColor))
            seatClass.findViewById<MaterialTextView>(getSeatClassHargaTextView(index)).setTextColor(resources.getColor(textColor))
            seatClass.findViewById<ShapeableImageView>(getSeatClassSuccess(index)).visibility= if (isSelected){
                View.VISIBLE
            }else{
                View.GONE
            }
            if (isSelected){
                seatClassName = seatClass.findViewById<MaterialTextView>(getSeatClassTextView(index)).text.toString()
            }
        }
    }

    private fun getSeatClassSuccess(index: Int): Int {
        return when(index){
            0 ->R.id.ivChecklist
            1 ->R.id.ivChecklist2
            2 ->R.id.ivChecklist3
            3 ->R.id.ivChecklist4
            else -> throw IllegalArgumentException("Invalid index")
        }
    }

    private fun getSeatClassHargaTextView(index: Int): Int {
        return when(index){
            0 ->R.id.tvHargaEconomy
            1 ->R.id.tvHargaPremiumEconomy
            2 ->R.id.tvHargaBusiness
            3 ->R.id.tvHargaFirstClass
            else -> throw IllegalArgumentException("Invalid index")
        }
    }

    private fun getSeatClassTextView(index: Int): Int {
        return when(index){
            0 ->R.id.tvEconomy
            1 ->R.id.tvPremiumEconomy
            2 ->R.id.tvBusiness
            3 ->R.id.tvFirstClass
            else -> throw IllegalArgumentException("Invalid index")
        }
    }
}