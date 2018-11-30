package com.example.pichau.rumoaomilhao.finance

import android.location.Location

enum class RealStateType{
    APARTMENT, FARM, HOUSE, OTHER
}
class RealEstate(var name: String, id: Int, currentValue:Number):
                    Asset(name, id, currentValue){
    var realEstateType: RealStateType? = null
    var location: Location? = null

}