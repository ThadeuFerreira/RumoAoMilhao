package com.example.pichau.rumoaomilhao

import android.os.Parcel
import android.os.Parcelable

class Person( var name: String,
              var age: Int,
              var address: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            TODO("name"),
            TODO("age"),
            TODO("address")) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}