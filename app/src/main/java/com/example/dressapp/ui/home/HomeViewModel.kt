package com.example.dressapp.ui.home

import Model.Dress
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val dressOne = "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Evelynn_15.jpg"
    val dressTwo =
        "https://cdn.shazoo.ru/471278_Dtb0IrdeUR_league_of_legends_fendomy_ahri_k.jpeg"

    private val _dress = MutableLiveData<List<Dress>>().apply {

        value = listOf(
            Dress("Dress1", "20 500", dressOne),
            Dress("Dress2", "35 999", dressTwo)
        )
    }


    val dress: LiveData<List<Dress>> = _dress
}