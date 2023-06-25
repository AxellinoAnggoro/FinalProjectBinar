package com.example.finalproject.view.ui.prosespembayaran

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentProsesPembayaranBinding

class ProsesPembayaranFragment : Fragment() {

    lateinit var binding :FragmentProsesPembayaranBinding
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

        binding.cvGopay.setOnClickListener {
            binding.apply {
                if (expandableLayout.visibility == View.GONE){
                    TransitionManager.beginDelayedTransition(cvGopay,AutoTransition())
                    expandableLayout.visibility = View.VISIBLE
                    constraintLayout.setBackgroundColor(resources.getColor(R.color.darkblue05))
                    ivArrow.setImageResource(R.drawable.baseline_keyboard_arrow_up_24)
                }else{
                    TransitionManager.beginDelayedTransition(cvGopay,AutoTransition())
                    expandableLayout.visibility = View.GONE
                    ivArrow.setImageResource(R.drawable.baseline_keyboard_arrow_down_24)
                    constraintLayout.setBackgroundColor(resources.getColor(R.color.neutral04))
                }
            }
        }
    }

}