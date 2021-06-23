package com.example.gift

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var passwordResetButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth.currentUser !=null) {
            goToMainActivity()
        }

        init()

        registerListeners()
    }

    private fun init() {

        emailEditText = findViewById(R.id.loginEmail)
        passwordEditText = findViewById(R.id.loginPassword)
        loginButton = findViewById(R.id.Login)
        registerButton = findViewById(R.id.Registration)
        passwordResetButton = findViewById(R.id.forgotPassword)
    }

    private fun registerListeners() {

        loginButton.setOnClickListener {

            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{startActivity(Intent(this, FragmentActivity::class.java))}

            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                    } else {
                        Toast.makeText(this, "Authentication failed!", Toast.LENGTH_SHORT).show()
                    }
                }


        }

        registerButton.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        passwordResetButton.setOnClickListener {
            startActivity(Intent(this, PasswordResetActivity::class.java))
        }

    }

    private fun goToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}