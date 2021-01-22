package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.lang.Exception

class Signup : AppCompatActivity() {
    private lateinit var imageview2: ImageView

    private lateinit var etFname: EditText
    private lateinit var etSname: EditText
    private lateinit var etUname: EditText
    private lateinit var etPassword: EditText
    private lateinit var radiobutton1: RadioButton
    private lateinit var radiobutton2: RadioButton
    private lateinit var btn3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageview2 = findViewById(R.id.imageview2)
        etFname = findViewById(R.id.etFname)
        etSname = findViewById(R.id.etSname)
        etUname = findViewById(R.id.etUname)
        etPassword = findViewById(R.id.etPassword)

        radiobutton1 = findViewById(R.id.radiobutton1)
        radiobutton2 = findViewById(R.id.radiobutton2)
        btn3 = findViewById(R.id.btn3)





        btn3.setOnClickListener {
            try {
                val intent = Intent(this, Signup::class.java)
                startActivity(intent)
            } catch (ex: Exception) {
                Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
            }

        }
    }
}