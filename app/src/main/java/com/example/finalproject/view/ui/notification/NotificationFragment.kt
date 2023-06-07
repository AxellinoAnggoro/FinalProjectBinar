package com.example.finalproject.view.ui.notification

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentNotificationBinding
import com.example.finalproject.model.ItemNotif
import com.example.finalproject.view.ui.adapter.NotifAdapter

class NotificationFragment : Fragment() {

    lateinit var binding : FragmentNotificationBinding
    private lateinit var notifAdapter: NotifAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        binding.rvNotif.layoutManager = layoutManager
        val itemNotif = listOf(
            ItemNotif(R.drawable.ic_notif,"Promosi","Dapatkan Potongan 50% Tiket!","Syarat dan Ketentuan berlaku!","20 Maret, 14:04"),
            ItemNotif(R.drawable.ic_notif,"Promosi","Dapatkan Potongan 50% Tiket!","Syarat dan Ketentuan berlaku!","20 Maret, 14:04"),
            ItemNotif(R.drawable.ic_notif,"Promosi","Dapatkan Potongan 50% Tiket!","Syarat dan Ketentuan berlaku!","20 Maret, 14:04"),
            ItemNotif(R.drawable.ic_notif,"Promosi","Dapatkan Potongan 50% Tiket!","Syarat dan Ketentuan berlaku!","20 Maret, 14:04"),
            ItemNotif(R.drawable.ic_notif,"Promosi","Dapatkan Potongan 50% Tiket!","Syarat dan Ketentuan berlaku!","20 Maret, 14:04"),
            ItemNotif(R.drawable.ic_notif,"Promosi","Dapatkan Potongan 50% Tiket!","Syarat dan Ketentuan berlaku!","20 Maret, 14:04"),
            ItemNotif(R.drawable.ic_notif,"Promosi","Dapatkan Potongan 50% Tiket!","Syarat dan Ketentuan berlaku!","20 Maret, 14:04"),
            ItemNotif(R.drawable.ic_notif,"Promosi","Dapatkan Potongan 50% Tiket!","Syarat dan Ketentuan berlaku!","20 Maret, 14:04"),
            ItemNotif(R.drawable.ic_notif,"Promosi","Dapatkan Potongan 50% Tiket!","Syarat dan Ketentuan berlaku!","20 Maret, 14:04"),
            ItemNotif(R.drawable.ic_notif,"Promosi","Dapatkan Potongan 50% Tiket!","Syarat dan Ketentuan berlaku!","20 Maret, 14:04"),
            ItemNotif(R.drawable.ic_notif,"Promosi","Dapatkan Potongan 50% Tiket!","Syarat dan Ketentuan berlaku!","20 Maret, 14:04"),
            ItemNotif(R.drawable.ic_notif,"Promosi","Dapatkan Potongan 50% Tiket!","Syarat dan Ketentuan berlaku!","20 Maret, 14:04")
        )
        notifAdapter = NotifAdapter(itemNotif)
        binding.rvNotif.adapter = notifAdapter
    }



}