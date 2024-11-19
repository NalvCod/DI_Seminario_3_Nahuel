package com.example.di_seminario_3_nahuel

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class paises : AppCompatActivity() {
    private lateinit var paises: TextView
    private lateinit var bandera: ImageView
    private lateinit var habitantes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paises)

        paises = findViewById(R.id.pais)
        bandera = findViewById(R.id.bandera)
        habitantes = findViewById(R.id.habitantes)

        val paisRecibido = intent.getParcelableExtra<Pais>("pais")

        paises.text = paisRecibido!!.nombre
        habitantes.text = paisRecibido.habitantes.toString()
        bandera.setImageResource(paisRecibido.bandera)
    }
}