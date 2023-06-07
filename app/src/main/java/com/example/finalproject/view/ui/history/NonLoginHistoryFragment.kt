package com.example.finalproject.view.ui.history

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.R

class NonLoginHistoryFragment : Fragment() {

    companion object {
        fun newInstance() = NonLoginHistoryFragment()
    }

    private lateinit var viewModel: NonLoginHistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_non_login_history, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NonLoginHistoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}