package com.example.di_seminario_3_nahuel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class Ejercicio2 : AppCompatActivity() {
    private lateinit var enviar : Button
    private lateinit var txt : TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)

        enviar = findViewById(R.id.enviar)
        txt = findViewById(R.id.datos)
        val intent = Intent (this, ejercicio2_2::class.java)

        enviar.setOnClickListener(){
            var numero = 13
            var texto = txt.text.toString()

            intent.putExtra("textoN", texto)
            intent.putExtra("num", numero)

            startActivity(intent)
        }
        }

    }
