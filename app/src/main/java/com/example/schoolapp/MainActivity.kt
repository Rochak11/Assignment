package com.example.schoolapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
   private lateinit var imageView: ImageView
   private lateinit var etUsername: EditText
   private lateinit var etPassword: EditText
   private lateinit var btn1: Button
   private lateinit var btn2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView= findViewById(R.id.imageView)
        etUsername=findViewById(R.id.etUsername)
        etPassword=findViewById(R.id.etPassword)
        btn1= findViewById(R.id.btn1)
        btn2= findViewById(R.id.btn2)


       btn2.setOnClickListener({
           var signUpIntent= Intent(this, SignUP::class.java)
           startActivity(signUpIntent)
       })
        btn1.setOnClickListener {
            login()
        }
        btn2.setOnClickListener {
            getSharedPref()

        }


        }

    private fun login() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = RepoUser()
                val response = repository.loginUser(username, password)
                if (response.success == true) {
                    ServiceBuilder.token = "Bearer " + response.token
                    startActivity(
                            Intent(
                                    this@MainActivity,
                                    Dashboard_Activity::class.java
                            )
                    )
                    finish()
                }

            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                            this@MainActivity,
                            "Login error", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    private fun getSharedPref() {
            val sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)
            val username = sharedPref.getString("username", "")
            val password = sharedPref.getString("password", "")
            Toast.makeText(
                this,
                "Username : $username and password : $password",
                Toast.LENGTH_SHORT
            )
                .show()
            TODO("Not yet implemented")

    }


}




