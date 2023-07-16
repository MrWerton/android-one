package com.notrew.one

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Home : AppCompatActivity() {
    private lateinit var preferences: SharedPreferences
    private lateinit var greetingText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        greetingText = findViewById(R.id.greetingText)
        preferences = getSharedPreferences("db_local", MODE_PRIVATE)
        readEmailFromLocally()
    }

    private fun readEmailFromLocally() {

        val email = preferences.getString("email", null)
        email?.let {
            val greeting = resources.getString(R.string.greeting, it)
            greetingText.text = greeting
        }

    }
}