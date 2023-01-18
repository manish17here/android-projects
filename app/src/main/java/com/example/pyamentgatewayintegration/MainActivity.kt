package com.example.pyamentgatewayintegration

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val donatenow = findViewById<Button>(R.id.donate_now)
        donatenow.setOnClickListener{
            val intent = Intent(this, donateactivity::class.java)
            startActivity(intent)
        }

    }
}