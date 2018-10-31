package com.example.pichau.rumoaomilhao

import android.location.Location
import com.example.pichau.rumoaomilhao.finance.Asset
import com.example.pichau.rumoaomilhao.finance.Liability

class Person( var name: String,
              val id: Int,
              var age: Int,
              var address: String) {

    val assets : MutableList<Asset> = mutableListOf()
    val liabilities : MutableList<Liability> = mutableListOf()
    var location: Location = Location("dummyprovider")
}