package com.example.healthapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.TextClock



class MainActivity : AppCompatActivity() {
    // on below line we are creating a variable.
    lateinit var app: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_text)

//        // on below line we are initializing our variables.
//        app = findViewById(R.id.text)
//
//        // on below line we are setting message for our text view.
//        app.text = "Welcome to Geeks for Geeks"

       // setMovementMethod(new ScrollingMovementMethod());


    }

}

