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
import com.example.finalproject.model.detail.DataDetail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPenerbanganFragment : Fragment() {
    lateinit var binding : FragmentDetailPenerbanganBinding
    lateinit var  detailVm: DetailPenerbanganViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPenerbanganBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMasuk.setOnClickListener {

        }

        val id = arguments?.getInt("id")
        detailVm = ViewModelProvider(this)[DetailPenerbanganViewModel::class.java]
        detailVm.fetchTicketId(id!!)
        detailVm.liveDataFlightId.observe(viewLifecycleOwner){ detail ->
            binding.apply {
                jadwalJam.text = detail!!.departureTime
                setBandara.text = detail.departureAirport.airportName
                typePlane.text = detail.airline.airlineName
                codePlane.text = detail.flightCode
                jmlBaggage.text = detail.airline.baggage.toString()
                jmlCabin.text = detail.airline.cabinBaggage.toString()
                jadwalJamPulang.text = detail.arrivalTime
                setBandaraTujuan.text = detail.arrivalAirport.airportName
            }
        }

    }

}