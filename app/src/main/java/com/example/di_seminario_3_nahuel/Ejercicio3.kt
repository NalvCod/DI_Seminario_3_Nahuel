package com.example.di_seminario_3_nahuel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio3 : AppCompatActivity() {

    private lateinit var enviar : Button
    private lateinit var insertar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        enviar = findViewById(R.id.enviar)
        insertar = findViewById(R.id.insertar)

        var lista = mutableListOf<String>()
        val intent = Intent (this, Ejercicio3_3::class.java)

        enviar.setOnClickListener(){

            startActivity(intent)
        }
        insertar.setOnClickListener(){
            lista.add(insertar.text.toString())
            intent.putExtra(lista.joinToString (",") , 0)
        }

    }
}