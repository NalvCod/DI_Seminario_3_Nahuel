package com.example.di_seminario_3_nahuel

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio3_3 : AppCompatActivity() {

    private lateinit var cadena : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio33)

        cadena = findViewById(R.id.cadena)

        val cadenaRecibida = intent.getStringArrayListExtra("lista")
        Log.v("debug", cadenaRecibida.toString())

        cadena.text = cadenaRecibida.toString()
    }
}