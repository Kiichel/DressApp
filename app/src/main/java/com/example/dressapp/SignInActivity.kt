package com.example.dressapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.loginEditId
import kotlinx.android.synthetic.main.activity_sign_in.passEditId

class SignInActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        auth = Firebase.auth

        if (auth.currentUser != null) {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }

    fun changeRegister(view: View) {
        val i = Intent(this, SignUpActivity::class.java)
        startActivity(i)
    }

    fun loginButton(view: View) {
        var email = loginEditId.editText?.text.toString().trim()
        var password = passEditId.editText?.text.toString().trim()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            Toast.makeText(
                baseContext, "Введите данные",
                Toast.LENGTH_SHORT
            )
                .show()
        } else {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser

                        //updateUI(user)

                        val i = Intent(this, MainActivity::class.java)
                        startActivity(i)
                    } else {
                        Log.w("TAG", "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                        //updateUI(null)
                    }
                }
        }


    }

    fun loginWithoutAuth(view: View) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }


}

