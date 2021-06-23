package com.example.gift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordResetActivity : AppCompatActivity() {

    private lateinit var resetMail : EditText
    private lateinit var code : Button

    private lateinit var mAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset)

        mAuth = FirebaseAuth.getInstance()

        this.init()

        this.registerListeners()
    }


    private fun init() {

        resetMail = findViewById(R.id.passwordResetMail)
        code = findViewById(R.id.code)
    }

    private fun registerListeners() {

        code.setOnClickListener {

            val email = resetMail.text.toString()
            if(email.isEmpty()){
                Toast.makeText(this,"Email is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Toast.makeText(this,"Check Email", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"ERROR", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}