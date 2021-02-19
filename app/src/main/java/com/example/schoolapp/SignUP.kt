package com.example.schoolapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.schoolapp.Repository.UserRepository
import com.example.schoolapp.data.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

        imageView1 = findViewById(R.id.imageView1)
        etFirstName = findViewById(R.id.etFirstName)
        etSecondName = findViewById(R.id.etSecondName)
        etUsername1 = findViewById(R.id.etUsername1)
        etPassword1 = findViewById(R.id.etPassword1)
        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        btnsignup = findViewById(R.id.btnsignup)

        btnsignup.setOnClickListener({ signUpUser() })
    }

    private fun signUpUser() {
        val fname = etFirstName.text.toString().trim()
        val lname = etSecondName.text.toString().trim()
        val username = etUsername1.text.toString().trim()
        val password = etPassword1.text.toString().trim()

        val user = User(fname, lname, username, password)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = UserRepository()
                val response = repository.registerUser(user)
                if (response.success) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@SignUP,
                            "Sign up success", Toast.LENGTH_SHORT
                        ).show()
                    }
                    finish()
                }

            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@SignUP,
                        ex.message, Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}