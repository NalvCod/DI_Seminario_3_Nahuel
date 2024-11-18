package com.example.di_seminario_3_nahuel

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.log
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

    private val casillaLibre = Array(3) { Array(3) { 0 } }
    private var turnoUsuario = true
    private var turnos = 0

    private val casillas = listOf(
        listOf(pos00, pos01, pos02),
        listOf(pos10, pos11, pos12),
        listOf(pos20, pos21, pos22)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        pos00 = findViewById(R.id.pos00)
        pos01 = findViewById(R.id.pos01)
        pos02 = findViewById(R.id.pos02)
        pos10 = findViewById(R.id.pos10)
        pos11 = findViewById(R.id.pos11)
        pos12 = findViewById(R.id.pos12)
        pos20 = findViewById(R.id.pos20)
        pos21 = findViewById(R.id.pos21)
        pos22 = findViewById(R.id.pos22)



        for (x in 0..2) {
            for (y in 0..2) {
                casillas[x][y].setOnClickListener {
                    var esPulsable = checkearEsPulsable(x, y)
                    Log.v("hola", "SE PULSA")
                    if (esPulsable) {
                        jugadaUsuario(x, y)
                        var heganado = checkearGanador()
                        if (heganado == 0) {
                            jugadaMaquina(casillas)
                            checkearVictoriaMaquina()
                        }
                    }
//                    if (turnoUsuario && casillaLibre[x][y] == 0) {
//                        casillas[x][y].setImageResource(R.drawable.tresenrayax)
//                        casillaLibre[x][y] = 1
//                        turnos++
//                        turnoUsuario = false
//                    }
                }
            }
        }
    }

    private fun checkearVictoriaMaquina() {

    }

    private fun jugadaMaquina(casillas: List<List<ImageView>>) {
        var x: Int
        var y: Int

        do {
            x = Random.nextInt(0, 3)
            y = Random.nextInt(0, 3)
        } while (checkearEsPulsable(x, y))


        casillas[x][y].setImageResource(R.drawable.tresenrayao)
        casillaLibre[x][y] = 2
        turnos++
        turnoUsuario = true

    }

    private fun jugadaUsuario( x: Int, y: Int) {
        casillas[x][y].setImageResource(R.drawable.tresenrayax)
    }

    private fun checkearGanador(): Int {
        return 0
    }

    private fun checkearEsPulsable(x: Int, y: Int): Boolean {
        if (casillaLibre[x][y] == 0) {
            return true
        } else return false
    }
}
