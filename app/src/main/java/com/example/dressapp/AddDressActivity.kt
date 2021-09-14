package com.example.dressapp

import Model.Dress
import Model.Message
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_add_dress.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class AddDressActivity : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_dress)

        db = Firebase.firestore
    }

    fun addDresses(view: View) {
        var nameDress = nameAddDressId.editText?.text.toString()
        var priceDress = priceAddDressId.editText?.text.toString()
        var imgDress = imgAddDressId.editText?.text.toString()

        if (nameDress.isNullOrEmpty() || priceDress.isNullOrEmpty() || imgDress.isNullOrEmpty()) {
            Toast.makeText(
                baseContext, "Введите данные",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val dress = Dress(nameDress, priceDress, imgDress)
            db.collection("dresses")
                .add(dress)
                .addOnSuccessListener { documentReference ->
                    Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w("TAG", "Error adding document", e)
                }
            nameAddDressId.editText?.text?.clear()
            priceAddDressId.editText?.text?.clear()
            imgAddDressId.editText?.text?.clear()

            Toast.makeText(
                baseContext, "Платье добавлено",
                Toast.LENGTH_SHORT
            ).show()

        }
    }

}