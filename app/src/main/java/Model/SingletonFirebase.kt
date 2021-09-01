package Model

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object SingletonFirebase {
    private val database = Firebase.database("https://dressapp-e63b3-default-rtdb.asia-southeast1.firebasedatabase.app/")
    private val myRef = database.getReference("message")


    fun sendMessage(username: String, textMessage: String) {
        val messChat = Message(textMessage, username, null)
        myRef.push().child("textMessages").setValue(messChat)

    }

}