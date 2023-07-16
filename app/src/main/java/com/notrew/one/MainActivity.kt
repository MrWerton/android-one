package com.notrew.one

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var emailInput: TextView
    private lateinit var passwordInput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.loginButton)
        emailInput = findViewById(R.id.inputEmail)
        passwordInput = findViewById(R.id.inputPassword)

        loginButton.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val emailValue = emailInput.text.toString().trim()
        val passwordValue = passwordInput.text.toString().trim()

        if (emailValue.isNotBlank()) {
            println(emailValue)
            println(passwordValue)
        } else {
            Snackbar.make(
                findViewById(android.R.id.content),
                "Please the credentials should be informed.",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}