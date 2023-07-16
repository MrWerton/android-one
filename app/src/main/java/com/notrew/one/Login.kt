package com.notrew.one

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class Login : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var emailInput: TextView
    private lateinit var passwordInput: TextView
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        preferences = getSharedPreferences("db_local", Context.MODE_PRIVATE)

        loginButton = findViewById(R.id.loginButton)
        emailInput = findViewById(R.id.inputEmail)
        passwordInput = findViewById(R.id.inputPassword)
        getCredentialsLocally()


        loginButton.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val emailValue = emailInput.text.toString().trim()
        val passwordValue = passwordInput.text.toString().trim()

        if (emailValue.isNotBlank()) {
            saveLocally(emailValue, passwordValue)

            makeText(
                this,
                "Login success \uD83D\uDE80.",
                Toast.LENGTH_SHORT
            ).show()
            navigateToHome()
        } else {
            Snackbar.make(
                findViewById(android.R.id.content),
                "Please the credentials should be informed.",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }


    private fun saveLocally(emailValue: String, passwordValue: String) {
        preferences.edit().apply {
            putString("email", emailValue)
            putString("password", passwordValue)
            apply()
        }
    }

    private fun getCredentialsLocally() {
        val email = preferences.getString("email", null)
        val password = preferences.getString("password", null)
        if (!email.isNullOrBlank() && !password.isNullOrBlank()) {
            emailInput.text = email
            passwordInput.text = password
        }
    }

    private fun navigateToHome() {
        val intent = Intent(this, Home::class.java)
        startActivity(intent)
    }
}