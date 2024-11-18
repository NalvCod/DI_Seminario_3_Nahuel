package com.example.di_seminario_3_nahuel

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ejercicio2_2 : AppCompatActivity() {

    private lateinit var txt : TextView
    private lateinit var num : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio22)

        txt = findViewById(R.id.txt)
        num = findViewById(R.id.txtnum)


        val numeroRecibido = intent.getIntExtra("num", 0)
        val textoRecibido = intent.getStringExtra("textoN")

        txt.text = "Numero recibido " + textoRecibido
        num.text = "Numero recibido: " + numeroRecibido

    }
}