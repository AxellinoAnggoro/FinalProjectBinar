package com.example.finalproject.view.ui.detailpenerbangan

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentDetailPenerbanganBinding

class DetailPenerbanganFragment : Fragment() {

    lateinit var binding : FragmentDetailPenerbanganBinding
    companion object {
        fun newInstance() = DetailPenerbanganFragment()
    }

    private  val viewModel: DetailPenerbanganViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPenerbanganBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}