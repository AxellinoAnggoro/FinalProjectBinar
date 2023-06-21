package com.example.finalproject.view.ui.rincianpenerbangan

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.R

class RincianPenerbanganFragment : Fragment() {

    companion object {
        fun newInstance() = RincianPenerbanganFragment()
    }

    private lateinit var viewModel: RincianPenerbanganViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rincian_penerbangan, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RincianPenerbanganViewModel::class.java)
        // TODO: Use the ViewModel
    }

}