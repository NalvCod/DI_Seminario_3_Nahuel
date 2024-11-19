package com.example.di_seminario_3_nahuel

import android.media.Image
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pais (var nombre:String, var bandera:Int, var habitantes:Int) : Parcelable {

}