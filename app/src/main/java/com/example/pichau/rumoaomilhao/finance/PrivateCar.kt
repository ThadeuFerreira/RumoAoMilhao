package com.example.pichau.rumoaomilhao.finance

import java.time.Year


class PrivateCar(var name: String, id: Int) : Liability(name, id, "Car") {
    var maker: String = ""
    var model: String = ""
    var year: Year = Year.parse("1900")

    override fun toString(): String = "name = $name\nmodel = $model\nyear = ${year}\nmaker = $maker"
}