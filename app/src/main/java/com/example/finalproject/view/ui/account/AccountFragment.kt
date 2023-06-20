package com.example.finalproject.view.ui.account

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentAccountBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : Fragment() {

//    companion object {
//        fun newInstance() = AccountFragment()
//    }

//    private lateinit var viewModel: AccountViewModel
    lateinit var binding : FragmentAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvUbahProfil.setOnClickListener {
            findNavController().navigate(R.id.action_accountFragment_to_accountUbahProfileFragment)
        }

        binding.icEdit.setOnClickListener {
            findNavController().navigate(R.id.action_accountFragment_to_accountUbahProfileFragment)
        }

    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(AccountViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

}