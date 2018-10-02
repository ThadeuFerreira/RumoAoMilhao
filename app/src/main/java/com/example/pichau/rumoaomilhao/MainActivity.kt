package com.example.pichau.rumoaomilhao

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.DrawableRes
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    private val myList = arrayListOf("Thadeu", "Jussara", "Maria")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var person = Person("",0,"")
        homeBtn.setOnClickListener{
            val choseNumber = Random()
            val randomText = myList[choseNumber.nextInt(myList.count())]
            person.name = randomText
            if(randomText == "Thadeu"){
                homeImage.setImageResource(R.drawable.business_man)
            }
            profileNameTxt.text = randomText
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                totalBalanceTxt.text = choseNumber.doubles(100).toString()
            }
            else{
                totalBalanceTxt.text = 13040.43.toString()
            }
            println("You Clicked in Me $randomText!")

            val valueTV = TextView(this)
            valueTV.text = randomText
            investmentsLinearLayout.addView(valueTV)
        }
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
