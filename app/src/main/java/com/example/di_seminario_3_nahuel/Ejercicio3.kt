package com.example.di_seminario_3_nahuel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class Ejercicio3 : AppCompatActivity() {

    private lateinit var enviar : Button
    private lateinit var insertar : Button
    private lateinit var datos : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        enviar = findViewById(R.id.enviar)
        insertar = findViewById(R.id.insertar)
        datos = findViewById(R.id.datos)

        var lista = ArrayList<String>()
        val intent = Intent (this, Ejercicio3_3::class.java)

        enviar.setOnClickListener(){
            Log.v("debug", lista.toString())
            intent.putStringArrayListExtra("lista", lista)
            startActivity(intent)
        }
        insertar.setOnClickListener(){
            lista.add(datos.text.toString())
            datos.text?.clear()
        }

    }
}