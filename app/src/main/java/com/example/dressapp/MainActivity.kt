package com.example.dressapp

import Model.Dress
import Model.DressRecyclerViewAdapter
import Model.Message
import Model.MessagesRecyclerViewAdapter
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_messages.*

class MainActivity : AppCompatActivity() {
    lateinit var dress: List<Dress>
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dress = fillDress()
        dressRecycler.layoutManager = LinearLayoutManager(this)
        dressRecycler.adapter = DressRecyclerViewAdapter(dress)

    }

    @SuppressLint("ResourceType")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.signOut -> {
                Firebase.auth.signOut()
                startA()
            }
            R.id.cartMenuId ->{
                val i = Intent(this, CartActivity::class.java)
                startActivity(i)
            }

            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    fun startA() {
        val i = Intent(this, SignInActivity::class.java)
        startActivity(i)
    }

    private fun fillDress(): List<Dress>{
        val dressOne = "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Evelynn_15.jpg"
        val dressTwo =
            "https://cdn.shazoo.ru/471278_Dtb0IrdeUR_league_of_legends_fendomy_ahri_k.jpeg"

        return listOf(
            Dress("Dress1", "20 500", dressOne),
            Dress("Dress2", "35 999", dressTwo)
        )
    }
}