package com.example.pichau.rumoaomilhao

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.DrawableRes
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val myList = arrayListOf("Thadeu", "Jussara", "Maria")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        homeTxt.text = stringFromJNI()

        homeBtn.setOnClickListener{
            val choseNumber = Random()
            val randomText = myList[choseNumber.nextInt(myList.count())]
            if(randomText == "Thadeu"){
                homeImage.setImageResource(R.drawable.business_man)
            }
            homeTxt.text = randomText
            println("You Clicked in Me $randomText!")
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
