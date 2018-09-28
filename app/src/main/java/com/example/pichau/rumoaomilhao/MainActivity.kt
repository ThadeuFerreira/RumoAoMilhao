package com.example.pichau.rumoaomilhao

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val myList = arrayListOf("Thadeu", "Jussara", "Maria")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        homeTxt.text = stringFromJNI()


        homeBtn.setOnClickListener{
            val choseNumber = Random()
            val randomText = myList[choseNumber.nextInt(myList.count())]
            println("You Clickec in Me $randomText!")
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
