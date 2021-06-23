package com.example.gift

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var showEmail : TextView
    private lateinit var showUId : TextView
    private lateinit var passwordChangeButton : Button
    private lateinit var logoutButton : Button

    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        init()

        registerListener()


    }

    private fun init() {

        showEmail = findViewById(R.id.emailView)
        showUId = findViewById(R.id.userId)
        passwordChangeButton = findViewById(R.id.passwordChange)
        logoutButton = findViewById(R.id.logOut)

        showEmail.text = mAuth.currentUser?.email
        showUId.text = mAuth.currentUser?.uid
    }

    private fun registerListener() {

        passwordChangeButton.setOnClickListener {
            startActivity(Intent(this, PasswordChangeActivity::class.java))
        }

        logoutButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            mAuth.signOut()
            finish()
        }
    }
}