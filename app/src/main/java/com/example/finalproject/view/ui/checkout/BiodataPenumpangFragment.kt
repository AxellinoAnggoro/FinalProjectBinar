package com.example.finalproject.view.ui.checkout

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentBiodataPemesanBinding
import com.example.finalproject.databinding.FragmentBiodataPenumpangBinding
import com.example.finalproject.model.passenger.Penumpang
import com.example.finalproject.model.passenger.PenumpangRequest
import com.example.finalproject.view.ui.home.HomeViewModel

class BiodataPenumpangFragment : Fragment() {
    lateinit var binding: FragmentBiodataPenumpangBinding
    lateinit var homeVm: HomeViewModel
    lateinit var checkoutVm: CheckoutViewModel
    lateinit var passPref: SharedPreferences
    lateinit var bioAdapter: BioAdapter
    lateinit var tokenPref: SharedPreferences
    private val CheckVm: CheckViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBiodataPenumpangBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeVm = ViewModelProvider(this)[HomeViewModel::class.java]
        checkoutVm = ViewModelProvider(this)[CheckoutViewModel::class.java]
        passPref = requireContext().getSharedPreferences("data_penumpang", Context.MODE_PRIVATE)
        tokenPref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)

        val token = tokenPref.getString("token", "")
        val totalPassenger = passPref.getString("passenger", "")?.toInt()



//        binding.btnLanjut.setOnClickListener {
//            val dataList = CheckVm.getDataList()
//            // TODO: Cari Id ticket
//            val penumpangData = PenumpangRequest(idTicket!!.toString(), dataList, totalPassenger!!)
//
//            // TODO: Input edit text
//            checkoutVm.addPassenger(token!!)
//            checkoutVm.liveDataPassenger.observe(viewLifecycleOwner) {
//                if (it != null) {
//                    Toast.makeText(
//                        requireContext(),
//                        "Berhasil Menambahkan data penumpang",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//        }


        binding.icToolbar.setOnClickListener {
            findNavController().navigate(R.id.biodataPemesanFragment)
        }
    }

//    private fun initPassengerAdapter() {
//        val totalPassenger = passPref.getString("passenger", "")?.toInt()
//
//        val listPenumpang: ArrayList<Penumpang> = ArrayList()
//        for (i in 1..totalPassenger!!) {
//            listPenumpang.add(Penumpang("Penumpang $i"))
//        }
//
//        binding.rvDewasa.apply {
//            layoutManager =
//                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//            bioAdapter = BioAdapter(listPenumpang)
//            adapter = bioAdapter
//            bioAdapter.setOnItemClickListener(object : BioAdapter.OnItemClickListener {
//                override fun onItemClick(position: Int) {
//                    Toast.makeText(
//                        requireContext(),
//                        "posisi card ini $position",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    val bundle = Bundle()
//                    val name = listPenumpang[position].penumpang
//                    bundle.putInt("index", position)
//                    bundle.putString("penumpang", name)
//                    findNavController().navigate(
//                        R.id.action_biodataPenumpangFragment_to_rincianPenerbanganFragment2,
//                        bundle
//                    )
//                }
//
//            })
//
//        }
//    }
}
