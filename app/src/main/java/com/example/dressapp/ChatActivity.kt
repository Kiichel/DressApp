package com.example.dressapp

import Recycler.ChatRecyclerViewAdapter
import Model.Message
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    private lateinit var database: FirebaseDatabase
    private lateinit var myRef: DatabaseReference
    private lateinit var chatRecyclerViewAdapter: ChatRecyclerViewAdapter
    private lateinit var messages: MutableList<Message>
    private lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        database =
            Firebase.database(Config.DATABASE_URL)
        myRef = database.getReference("message")

        val user = Firebase.auth.currentUser
        user.let {
            userName = user?.displayName.toString()
        }

        messages = mutableListOf()
        chatRecyclerViewAdapter = ChatRecyclerViewAdapter(messages)
        recyclerViewChatId.layoutManager = LinearLayoutManager(this)
        recyclerViewChatId.adapter = chatRecyclerViewAdapter


        sendMessagesEditTextId.setEndIconOnClickListener {
            val text = send2MessagesEditTextId.text
            sendMessage(userName, text.toString())
            send2MessagesEditTextId.text = null
        }

        addPostEventListener(myRef)
    }

    private fun sendMessage(username: String, textMessage: String) {
        val messChat = Message(textMessage, username, null)
        myRef.push().setValue(messChat)
    }

    private fun addPostEventListener(postReference: DatabaseReference) {
        val postRef = object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("Messages count", "Messages count is: ${snapshot.childrenCount}")

                messages.clear()

                for (value in snapshot.children) {
                    val obj = value.getValue<Message>()
                    Log.d("Messages", "Value is: ${obj?.textMessage}")
                    messages.add(obj!!)
                }

                chatRecyclerViewAdapter.notifyDataSetChanged()
                recyclerViewChatId.scrollToPosition(messages.size - 1)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("don't working", "Failed to read value.", error.toException())
            }
        }

        postReference.addValueEventListener(postRef)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }

        return super.dispatchTouchEvent(ev)
    }
}