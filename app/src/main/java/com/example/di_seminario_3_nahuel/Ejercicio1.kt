package com.example.di_seminario_3_nahuel

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
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
    private lateinit var mensajeVictoria : TextView

    private var tablero = Array(3) { Array(3) { 0 } }
    private var turnoUsuario = true
    private var turno = 0

    private lateinit var  casillas :  List<List<ImageView>>

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
        mensajeVictoria = findViewById(R.id.mensajeVictoria)

        casillas = listOf(
            listOf(pos00, pos01, pos02),
            listOf(pos10, pos11, pos12),
            listOf(pos20, pos21, pos22)
        )

        for (x in 0..2) {
            for (y in 0..2) {
                casillas[x][y].setOnClickListener {
                    var esPulsable = checkearEsPulsable(x, y)
                    Log.v("debug", "SE PULSA")
                    if (esPulsable) {
                        jugadaUsuario(x, y)
                        if (turno < 5){
                            jugadaMaquina()
                            checkearVictoria()
                        }
                    }
                    if (resultado()){
                        for (i in 0 .. 2){
                            for (j in 0 .. 2){
                                tablero[i][j] = 65
                            }
                        }
                    }

                }
            }
        }
    }

    private fun checkearVictoria():Int {
        for (i in 0 .. 2){
            if (tablero[i][0] == tablero[i][1] && tablero[i][1] ==  tablero[i][2]){
                return tablero[i][0]
            }
            if (tablero[0][i] == tablero[1][i] && tablero[1][i] ==  tablero[2][i]){
                return tablero[0][i]
            }
        }

        if (tablero[0][0] == tablero[1][1] && tablero [1][1] == tablero[2][2]) return tablero[0][0]
        if (tablero[2][0] == tablero[1][1] && tablero [1][1] == tablero[0][2]) return tablero[2][0]
        return 0
    }

    private fun jugadaMaquina() {
        var x: Int
        var y: Int

        do {
            x = Random.nextInt(0, 3)
            y = Random.nextInt(0, 3)
        } while (!(checkearEsPulsable(x, y)))


        casillas[x][y].setImageResource(R.drawable.tresenrayao)
        tablero[x][y] = 2

        turnoUsuario = true

    }

    private fun jugadaUsuario( x: Int, y: Int) {
        Log.v("debug", "METODO " +x + "-" +y)
        casillas[x][y].setImageResource(R.drawable.tresenrayax)
        tablero[x][y] = 1
        turno++
    }

    private fun checkearEsPulsable(x: Int, y: Int): Boolean {
        return (tablero[x][y] == 0)
    }

    private fun resultado():Boolean{
        if (checkearVictoria() == 1){
            mensajeVictoria.text = "HAS GANADO"
            return true
        }

        if (checkearVictoria() == 2){
            mensajeVictoria.text = "HA GANADO LA MÁQUINA"
            return true
        }
        else return false
    }
}
