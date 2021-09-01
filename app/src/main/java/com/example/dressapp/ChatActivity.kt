package com.example.dressapp

import Model.Message
import Model.SingletonFirebase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)


        sendMessagesEditTextId.setEndIconOnClickListener {
            val text = send2MessagesEditTextId.text
            SingletonFirebase.sendMessage("Olga Komarova", text.toString())

        }
    }


}