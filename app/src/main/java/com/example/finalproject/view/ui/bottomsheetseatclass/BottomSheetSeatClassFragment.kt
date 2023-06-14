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
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentBottomSheetSeatClassBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.card.MaterialCardView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class BottomSheetSeatClassFragment : BottomSheetDialogFragment() {

    lateinit var binding : FragmentBottomSheetSeatClassBinding

    companion object {
        val bottomTag : String = "TAGSEATCLASS"
    }

    private lateinit var viewModel: BottomSheetSeatClassViewModel

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

        binding.cv1.setOnClickListener {
            resetCardViews()
            binding.cv1.setBackgroundColor(resources.getColor(R.color.darkblue05))
            binding.tvEconomy.setTextColor(resources.getColor(R.color.neutral01))
            binding.tvHarga.setTextColor(resources.getColor(R.color.neutral01))
            binding.ivChecklist.setImageDrawable(resources.getDrawable(R.drawable.ic_checklist))
        }

        binding.cv2.setOnClickListener {
            resetCardViews()
            binding.cv2.setBackgroundColor(resources.getColor(R.color.darkblue05))
            binding.tvEconomy2.setTextColor(resources.getColor(R.color.neutral01))
            binding.tvHarga2.setTextColor(resources.getColor(R.color.neutral01))
            binding.ivChecklist2.setImageDrawable(resources.getDrawable(R.drawable.ic_checklist))
        }

        binding.cv3.setOnClickListener {
            resetCardViews()
            binding.cv3.setBackgroundColor(resources.getColor(R.color.darkblue05))
            binding.tvEconomy3.setTextColor(resources.getColor(R.color.neutral01))
            binding.tvHarga3.setTextColor(resources.getColor(R.color.neutral01))
            binding.ivChecklist3.setImageDrawable(resources.getDrawable(R.drawable.ic_checklist))
        }

        binding.cv4.setOnClickListener {
            resetCardViews()
            binding.cv4.setBackgroundColor(resources.getColor(R.color.darkblue05))
            binding.tvEconomy4.setTextColor(resources.getColor(R.color.neutral01))
            binding.tvHarga4.setTextColor(resources.getColor(R.color.neutral01))
            binding.ivChecklist4.setImageDrawable(resources.getDrawable(R.drawable.ic_checklist))
        }
    }

    private fun resetCardViews() {
        binding.cv1.setBackgroundColor(resources.getColor(android.R.color.transparent))
        binding.cv2.setBackgroundColor(resources.getColor(android.R.color.transparent))
        binding.cv3.setBackgroundColor(resources.getColor(android.R.color.transparent))
        binding.cv4.setBackgroundColor(resources.getColor(android.R.color.transparent))

        binding.tvEconomy.setTextColor(resources.getColor(R.color.neutral05))
        binding.tvEconomy2.setTextColor(resources.getColor(R.color.neutral05))
        binding.tvEconomy3.setTextColor(resources.getColor(R.color.neutral05))
        binding.tvEconomy4.setTextColor(resources.getColor(R.color.neutral05))

        binding.tvHarga.setTextColor(resources.getColor(R.color.darkblue05))
        binding.tvHarga2.setTextColor(resources.getColor(R.color.darkblue05))
        binding.tvHarga3.setTextColor(resources.getColor(R.color.darkblue05))
        binding.tvHarga4.setTextColor(resources.getColor(R.color.darkblue05))


        binding.ivChecklist.setImageDrawable(null)
        binding.ivChecklist2.setImageDrawable(null)
        binding.ivChecklist3.setImageDrawable(null)
        binding.ivChecklist4.setImageDrawable(null)
    }


}