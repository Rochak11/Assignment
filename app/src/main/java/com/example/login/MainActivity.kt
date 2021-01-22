package com.example.login
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var imageview1: ImageView
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageview1 = findViewById(R.id.imageview1)
        et1= findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)

        btn2.setOnClickListener {
            try {
                val intent = Intent(this, Signup::class.java)
                startActivity(intent)
            } catch (ex: Exception) {
                Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
            }
        }

    }
}