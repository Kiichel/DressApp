package com.example.dressapp.ui.home

import Model.Dress
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel() : ViewModel() {

    private var _dress = MutableLiveData<List<Dress>>().apply {

        value = listOf()
    }
    init {
        HomeModel.getAll {
            val tmp = it
            _dress.apply {
                value = tmp
            }
        }
    }


    val dress: LiveData<List<Dress>> = _dress
}