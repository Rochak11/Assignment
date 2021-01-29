package com.example.login
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var imageview: ImageView
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageview = findViewById(R.id.imageview1)
        et1= findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)

        btn2.setOnClickListener {
            getSharedPref()

            val intent = Intent(this, Signup::class.java)
            intent.putExtra()
            startActivity(intent)
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

private fun Intent.putExtra() {
    TODO("Not yet implemented")
}

object textToPass {

}
