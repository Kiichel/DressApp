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
        return listOf(
            Message("Hi", "Olga Komarova", "e"),
            Message("Hello", "Olga Komarova", "e"),
            Message("He-he-he", "Olga Komarova", "e"),
            Message("Good Morning", "Olga Komarova", "e")
        )
    }
}