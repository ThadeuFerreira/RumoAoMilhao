package com.example.pichau.rumoaomilhao

import android.annotation.SuppressLint
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.widget.TextView
import com.example.pichau.rumoaomilhao.finance.PrivateCar
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.math.RoundingMode
import java.text.DecimalFormat
import java.time.Year
import com.google.firebase.database.FirebaseDatabase
import java.time.LocalDateTime


class MainActivity : AppCompatActivity() {

    private val myList = arrayListOf("Carlos", "Jussara", "Maria")
    private val carList = arrayListOf("Fiat", "Volks Wagen", "Ford", "Nissan")
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    fun IntRange.random() =
            Random().nextInt((endInclusive + 1) - start) +  start

    private fun runFirebase(obj:Any){
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")
        val currentDateTime = LocalDateTime.now()

        myRef.setValue("Hello: Today is $currentDateTime")
        val myRef2 = database.getReference("/")
        val objType = obj.javaClass.name.substringAfterLast('.')
        val key = myRef2.child(objType).push().key
        if (key != null) {
            myRef2.child(objType).child(key).setValue(obj)
        }

    }

    @SuppressLint("MissingPermission")
    private fun getLocation(): Location{
        var latitude: Double? = 0.0
        var longitude: Double? = 0.0
        fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    latitude =  location?.latitude
                    longitude = location?.longitude
                }
        val local = Location("provider")
        local.latitude = latitude!!
        local.longitude = longitude!!
        return local

    }
    @SuppressLint("ObsoleteSdkInt")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val person = Person("",1,0,"")
        homeBtn.setOnClickListener{
            val choseNumber = Random()
            val randomText = myList[choseNumber.nextInt(myList.count())]
            person.name = randomText
            if(randomText == "Thadeu"){
                homeImage.setImageResource(R.drawable.business_man)
            }
            var car = PrivateCar()
            for(i in 0..3){
                addCar(choseNumber, car, i, person)
            }

            profileNameTxt.text = person.name
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.CEILING
            totalBalanceTxt.text = df.format(choseNumber.nextDouble()*10000)

            println("You Clicked in Me $randomText!")
            val valueTV = TextView(this)
            valueTV.text = randomText
            investmentsLinearLayout.addView(valueTV)
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
            person.location = getLocation()
            runFirebase(person)
        }
    }

    private fun addCar(choseNumber: Random, car: PrivateCar?, i: Int, person: Person) {
        var car1 = car
        val carText = carList[choseNumber.nextInt(carList.count())]
        car1 = PrivateCar(carText, choseNumber.nextInt(500))
        car1.maker = "fabricante - $i"
        car1.year = Year.parse((1950..2020).random().toString())
        car1.model = "modelo - $i"
        person.liabilities.add(car1)
        runFirebase(car1)
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
