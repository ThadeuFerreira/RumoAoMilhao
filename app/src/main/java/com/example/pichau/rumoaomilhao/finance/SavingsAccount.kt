package com.example.pichau.rumoaomilhao.finance

import java.math.BigDecimal

class SavingsAccount(var name: String, id: Int, currentValue: BigDecimal):
                        Asset(name, id, currentValue){

}