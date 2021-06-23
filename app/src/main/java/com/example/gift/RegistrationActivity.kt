package com.example.gift

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {

    private lateinit var registerMail : EditText
    private lateinit var registerPassword : EditText
    private lateinit var registerName : EditText
    private lateinit var registerButton : Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)


        mAuth = FirebaseAuth.getInstance()

        this.init()

        this.registerListeners()
    }

    private fun init() {

        registerMail = findViewById(R.id.registerEmail)
        registerPassword = findViewById(R.id.registerPassword)
        registerName = findViewById(R.id.userName)
        registerButton = findViewById(R.id.registrationButton)
    }

    private fun registerListeners() {

        registerButton.setOnClickListener {

            val email = registerMail.text.toString()
            val password = registerPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Email or Password is empty", Toast.LENGTH_SHORT).show()
            }else{
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful) {
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }else{
                            Toast.makeText(this,"Authentication Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}