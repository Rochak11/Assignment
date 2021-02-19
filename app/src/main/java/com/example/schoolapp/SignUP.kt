package com.example.schoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton

class SignUP : AppCompatActivity() {
    private lateinit var imageView1: ImageView
    private lateinit var etFirstName: EditText
    private lateinit var etSecondName: EditText
    private lateinit var etUsername1: EditText
    private lateinit var etPassword1: EditText
    private lateinit var rb1: RadioButton
    private lateinit var rb2: RadioButton
    private lateinit var btnsignup: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_u_p)

    imageView1=findViewById(R.id.imageView1)
    etFirstName=findViewById(R.id.etFirstName)
    etSecondName=findViewById(R.id.etSecondName)
    etUsername1=findViewById(R.id.etUsername1)
    etPassword1=findViewById(R.id.etPassword1)
    rb1=findViewById(R.id.rb1)
    rb2=findViewById(R.id.rb2)
    btnsignup=findViewById(R.id.btnsignup)

    }
}