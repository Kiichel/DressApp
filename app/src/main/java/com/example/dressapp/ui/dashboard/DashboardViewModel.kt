package com.example.dressapp.ui.dashboard

import Model.Message
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _messages = MutableLiveData<List<Message>>().apply {
        value = listOf()
    }
    val messages: LiveData<List<Message>> = _messages
}