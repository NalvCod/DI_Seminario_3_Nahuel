package com.example.di_seminario_3_nahuel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio4 : AppCompatActivity() {
    private lateinit var espanha : Button
    private lateinit var francia : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio4)

        espanha = findViewById(R.id.espanha)
        francia = findViewById(R.id.francia)
        var intent = Intent (this, paises::class.java)

        espanha.setOnClickListener(){
            var espanha = Pais("España", R.drawable.espanha, 5000000)
            intent.putExtra("pais", espanha)
            startActivity(intent)
        }

        francia.setOnClickListener(){
            var francia = Pais("Francia", R.drawable.francia, 300000)
            intent.putExtra("pais", francia)
            startActivity(intent)
        }

    }
}