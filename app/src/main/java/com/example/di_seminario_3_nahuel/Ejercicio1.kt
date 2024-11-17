package com.example.di_seminario_3_nahuel

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Ejercicio1 : AppCompatActivity() {
    private lateinit var pos00: ImageView
    private lateinit var pos01: ImageView
    private lateinit var pos02: ImageView
    private lateinit var pos10: ImageView
    private lateinit var pos11: ImageView
    private lateinit var pos12: ImageView
    private lateinit var pos20: ImageView
    private lateinit var pos21: ImageView
    private lateinit var pos22: ImageView

    private val casillaLibre = Array(3) { Array(3) { true } }
    private var turnoUsuario = true
    private var turnos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        // Vincular vistas
        pos00 = findViewById(R.id.pos00)
        pos01 = findViewById(R.id.pos01)
        pos02 = findViewById(R.id.pos02)
        pos10 = findViewById(R.id.pos10)
        pos11 = findViewById(R.id.pos11)
        pos12 = findViewById(R.id.pos12)
        pos20 = findViewById(R.id.pos20)
        pos21 = findViewById(R.id.pos21)
        pos22 = findViewById(R.id.pos22)

        val casillas = listOf(
            listOf(pos00, pos01, pos02),
            listOf(pos10, pos11, pos12),
            listOf(pos20, pos21, pos22)
        )

        for (x in 0..2) {
            for (y in 0..2) {
                casillas[x][y].setOnClickListener {
                    if (turnoUsuario && casillaLibre[x][y]) {
                        casillas[x][y].setImageResource(R.drawable.tresenrayax)
                        casillaLibre[x][y] = false
                        turnos++
                        turnoUsuario = false
                    }
                }
            }
        }
    }

    private fun maquina(casillas: List<List<ImageView>>) {
        if (turnos >= 9) return

        do {
            val x = Random.nextInt(0, 3)
            val y = Random.nextInt(0, 3)

            if (casillaLibre[x][y]) {
                casillas[x][y].setImageResource(R.drawable.tresenrayao)
                casillaLibre[x][y] = false
                turnos++
                turnoUsuario = true
            }
        } while (true)
    }


}