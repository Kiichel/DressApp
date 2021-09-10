package com.example.dressapp

import Model.Users
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var myRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = Firebase.auth
        database =
            Firebase.database(Config.DATABASE_URL)
        myRef = database.getReference("users")
    }

    fun changeReg(view: View) {
        var email = loginTextEditTextId.text.toString()
        var password = passTextEditTextId.text.toString()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            Toast.makeText(
                baseContext, "Введите данные",
                Toast.LENGTH_SHORT
            )
                .show()
        } else {

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        createUser(user)
                        //updateUI(user)

                        val i = Intent(this, MainActivity::class.java)
                        i.putExtra("userName", nameEditId.editText?.text.toString().trim())
                        startActivity(i)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("TAG", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                        //updateUI(null)
                    }
                }
        }
    }

    private fun createUser(firebaseUser: FirebaseUser?) {
        var user = Users()
        user.userEmail = firebaseUser?.email.toString()
        user.userName = nameEditId.editText?.text.toString().trim()

        myRef.push().setValue(user)
    }

    fun backButton(view: View) {
        val i = Intent(this, SignInActivity::class.java)
        startActivity(i)
    }
}