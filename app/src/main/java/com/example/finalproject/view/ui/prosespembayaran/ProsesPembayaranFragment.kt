package com.example.finalproject.view.ui.prosespembayaran

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentProsesPembayaranBinding

import com.example.finalproject.view.ui.bottomsheetpaymentsuccess.BottomSheetPaymentSuccessFragment

class ProsesPembayaranFragment : Fragment() {

    lateinit var binding : FragmentProsesPembayaranBinding
    private lateinit var viewModel: ProsesPembayaranViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProsesPembayaranBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            cvGopay.setOnClickListener {
                if (expandLayoutGopay.visibility == View.GONE){
                    TransitionManager.beginDelayedTransition(cvGopay,AutoTransition())
                    expandLayoutGopay.visibility = View.VISIBLE
                    constraintLay.setBackgroundColor(resources.getColor(R.color.darkblue05))
                    ivArrow.setImageResource(R.drawable.baseline_keyboard_arrow_up_24)
                }else{
                    TransitionManager.beginDelayedTransition(cvGopay, AutoTransition())
                    expandLayoutGopay.visibility = View.GONE
                    ivArrow.setImageResource(R.drawable.baseline_keyboard_arrow_down_24)
                    constraintLay.setBackgroundColor(resources.getColor(R.color.neutral04))
                }
            }

            cvCreditCard.setOnClickListener {
                if (expandLayoutCreditCard.visibility ==View.GONE){
                    TransitionManager.beginDelayedTransition(cvCreditCard,AutoTransition())
                    expandLayoutCreditCard.visibility = View.VISIBLE
                    constraintLay2.setBackgroundColor(resources.getColor(R.color.darkblue05))
                    ivArrow2.setImageResource(R.drawable.baseline_keyboard_arrow_up_24)
                }else{
                    TransitionManager.beginDelayedTransition(cvCreditCard,AutoTransition())
                    expandLayoutCreditCard.visibility = View.GONE
                    constraintLay2.setBackgroundColor(resources.getColor(R.color.neutral04))
                    ivArrow2.setImageResource(R.drawable.baseline_keyboard_arrow_down_24)
                }
            }

            btnBayarGopay.setOnClickListener {
                BottomSheetPaymentSuccessFragment().show(requireActivity().supportFragmentManager,BottomSheetPaymentSuccessFragment.bottomTag)
                 }
            btnBayarCreditCard.setOnClickListener {
                BottomSheetPaymentSuccessFragment().show(requireActivity().supportFragmentManager,BottomSheetPaymentSuccessFragment.bottomTag)
                }

            topAppBar.setNavigationOnClickListener {
                findNavController().navigate(R.id.rincianPenerbanganFragment2)
            }
        }
    }

}