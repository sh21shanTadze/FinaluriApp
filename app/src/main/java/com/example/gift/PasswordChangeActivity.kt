package com.example.gift

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {

    private lateinit var newPasswordEdit: EditText
    private lateinit var newButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change2)

        mAuth = FirebaseAuth.getInstance()

        init()

        registerListener()
    }

    private fun init() {

        newPasswordEdit = findViewById(R.id.changedPassword)
        newButton = findViewById(R.id.changePassword)
    }

    private fun registerListener() {

        newButton.setOnClickListener {
            val newPassword = newPasswordEdit.text.toString()

            if (newPassword.isEmpty()) {
                Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            mAuth.currentUser?.updatePassword(newPassword)?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Password succesfully changed", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}