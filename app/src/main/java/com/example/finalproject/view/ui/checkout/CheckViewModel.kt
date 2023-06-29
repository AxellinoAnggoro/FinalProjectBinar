package com.example.finalproject.view.ui.checkout

import androidx.lifecycle.ViewModel
import com.example.finalproject.model.passenger.PenumpangPost

class CheckViewModel: ViewModel() {
    private val dataList: MutableList<PenumpangPost> = mutableListOf()

    fun addData(data:PenumpangPost) {
        dataList.add(data)
    }

    fun getDataList(): List<PenumpangPost> {
        return dataList
    }
}