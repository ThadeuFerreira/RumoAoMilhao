package com.example.pichau.rumoaomilhao.finance

import java.time.Year


class PrivateCar(var name: String, id: Int) : Liability(name, id) {
    constructor():this("", 0)

    var maker: String = ""
    var model: String = ""
    var year: Year = Year.parse("1900")
    var currentValue : Number? = 0
    var maintenanceCosts : Number? = 0

}