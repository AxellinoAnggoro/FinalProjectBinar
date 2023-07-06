package com.example.finalproject.view.ui.history

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.JsonToken
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentNonLoginHistoryBinding
import com.example.finalproject.model.ItemHistory
import com.example.finalproject.view.ui.adapter.HistoryAdapter

class NonLoginHistoryFragment : Fragment() {

    lateinit var binding : FragmentNonLoginHistoryBinding
    lateinit var pref : SharedPreferences
    private lateinit var viewModel: NonLoginHistoryViewModel
    private lateinit var historyAdapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNonLoginHistoryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)
        val token = pref.getString("token", "")

        loginNav(token!!)
    }

    fun loginNav(token: String){
        binding.apply {
            view?.post {
                btnMasuk.setOnClickListener {
                    findNavController().navigate(R.id.action_nonLoginHistoryFragment_to_loginFragment)
                }
            }
        }
    }

    private fun isLogin() {
        pref = requireContext().getSharedPreferences("login_data", Context.MODE_PRIVATE)
        val token = pref.getString("token", "")
        Log.d("History Fragment", "token: $token")
        if (token!!.isNotEmpty()) {
            binding.historyLogin.visibility = View.VISIBLE
            Log.d("Berhasil Login", "berhasil")
            binding.layoutNoLogin.visibility = View.GONE

            val layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
            binding.rvHasilPencarian.layoutManager = layoutManager
            val itemHistory = listOf(
                ItemHistory("Surabaya","5 Maret 2023","17:00","1h 0m","Bali","5 Maret 2023","18:00","247539","First Class","Rp. 11.000.000"),
                ItemHistory("Lombok","6 Juli 2023","10:00","2h 0m","Jakarta","6 Juli 2023","12:00","494320","Economy","Rp. 1.000.000"),
                ItemHistory("Jakarta","10 Juli 2023","20:00","12h 0m","London","11 Juli 2023","08:00","927772","Business","Rp. 21.000.000")
                )
            historyAdapter = HistoryAdapter(itemHistory)
            binding.rvHasilPencarian.adapter = historyAdapter

        } else {
            binding.layoutNoLogin.visibility = View.VISIBLE
            binding.historyLogin.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        isLogin()
    }

}