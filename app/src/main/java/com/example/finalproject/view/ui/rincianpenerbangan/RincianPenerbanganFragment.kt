package com.example.finalproject.view.ui.rincianpenerbangan

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentRincianPenerbanganBinding

class RincianPenerbanganFragment : Fragment() {
    lateinit var binding : FragmentRincianPenerbanganBinding
    companion object {
        fun newInstance() = RincianPenerbanganFragment()
    }

    private lateinit var viewModel: RincianPenerbanganViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRincianPenerbanganBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnLanjutPembayaran.setOnClickListener {
                findNavController().navigate(R.id.action_rincianPenerbanganFragment2_to_prosesPembayaranFragment)
            }
            topAppBar.setNavigationOnClickListener {
                findNavController().navigate(R.id.biodataPenumpangFragment)
            }
        }
    }

}