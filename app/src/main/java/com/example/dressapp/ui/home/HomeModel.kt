package com.example.dressapp.ui.home

import Model.Dress
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

object HomeModel {
    private val db = Firebase.firestore

    fun getAll(myCallback: (List<Dress>) -> Unit) {
        var dresses: MutableList<Dress> = mutableListOf()
        db.collection("dresses").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("TAG", "${document.data} ")
                    val dress = Dress(
                        document.data["dressName"] as String,
                        document.data["dressPrice"] as String,
                        document.data["dressImage"] as String?
                    )
                    dresses.add(dress)
                }
                myCallback(dresses)
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
    }
}