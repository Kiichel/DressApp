package com.example.dressapp

import Model.Message
import Model.MessagesRecyclerViewAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_messages.*

class MessagesActivity : AppCompatActivity() {
    lateinit var messages: List<Message>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)
        title = "Messages"

        messages = fillMessages()

        recyclerViewMessagesId.layoutManager = LinearLayoutManager(this)
        recyclerViewMessagesId.adapter = MessagesRecyclerViewAdapter(messages)
    }

    private fun fillMessages(): List<Message>{
        val imgEva = "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Evelynn_15.jpg"
        val imgKaisa =
            "https://cdn.shazoo.ru/471278_Dtb0IrdeUR_league_of_legends_fendomy_ahri_k.jpeg"
        val imgAhri =
            "https://cdn.shazoo.ru/471275_XollNs7rqd_league_of_legends_fendomy_ahri_k.jpeg"
        val imgSera =
            "https://images.contentstack.io/v3/assets/blt731acb42bb3d1659/blt8bd1c17cba18f90e/5f7fa5ecd4fbb50ef3077904/Seraphine_Skin_Explainer_Banner.jpg"

        return listOf(
            Message("Hi", "Olga Komarova", imgKaisa),
            Message("Hello", "Olga Komarova", imgSera),
            Message("He-he-he", "Olga Komarova", imgAhri),
            Message("Good Morning", "Olga Komarova", imgEva)
        )
    }
}