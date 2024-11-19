package com.example.di_seminario_3_nahuel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class MenuEjercicios : AppCompatActivity() {

    private lateinit var ej1: Button
    private lateinit var ej2: Button
    private lateinit var ej3: Button
    private lateinit var ej4: Button
    private lateinit var ej5: Button
    private lateinit var ej6: Button
    private lateinit var ej7: Button
    private lateinit var ej8: Button
    private lateinit var ej9: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menuejercicios)

        ej1 = findViewById(R.id.ej1)
        ej2 = findViewById(R.id.ej2)
        ej3 = findViewById(R.id.ej3)
        ej4 = findViewById(R.id.ej4)
        ej5 = findViewById(R.id.ej5)
        ej6 = findViewById(R.id.ej6)
        ej7 = findViewById(R.id.ej7)
        ej8 = findViewById(R.id.ej8)
        ej9 = findViewById(R.id.ej9)

        var botones = arrayOf(ej1, ej2, ej3, ej4, ej5, ej6, ej7, ej8, ej9)
        var nombre: String

        for (i in 0 until botones.size) {
            botones[i].setOnClickListener {
                if (i < 5) {
                    nombre = "Maqueta" + (i + 1)
                    Log.v("debug", nombre)
                } else {
                    nombre = "Ejercicio" + (i - 4)
                }

                    val intent = Intent(this, Class.forName("$packageName.$nombre"))
                    startActivity(intent)

            }
        }
    }
}
