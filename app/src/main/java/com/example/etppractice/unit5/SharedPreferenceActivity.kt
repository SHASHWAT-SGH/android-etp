package com.example.etppractice.unit5

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.etppractice.R

class SharedPreferenceActivity : AppCompatActivity() {

    lateinit var sharedpreferences1: SharedPreferences
    lateinit var name: EditText
    lateinit var email: EditText
    val mypreference = "mypref11"
    val Name = "nameKey"
    val Email = "emailKey"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shared_preference)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnRetr = findViewById<Button>(R.id.btnRetr)
        val btnClear = findViewById<Button>(R.id.btnClear)

        btnSave.setOnClickListener {
            save()
        }
        btnRetr.setOnClickListener {
            get()
        }
        btnClear.setOnClickListener {
            clear()
        }

        name = findViewById(R.id.etName)
        email = findViewById(R.id.etEmail)

        sharedpreferences1 = getSharedPreferences(mypreference, Context.MODE_PRIVATE)
        name.setText(sharedpreferences1.getString(Name, ""))
        email.setText(sharedpreferences1.getString(Email, ""))



    }

    fun save() {
        val n = name.text.toString()
        val e = email.text.toString()

        val editor = sharedpreferences1.edit()

        editor.putString(Name, n)
        editor.putString(Email, e)
        editor.apply()
    }

    fun clear() {
        name.setText("")
        email.setText("")
    }

    fun get() {
        sharedpreferences1 = getSharedPreferences(mypreference, Context.MODE_PRIVATE)
        name.setText(sharedpreferences1.getString(Name, ""))
        email.setText(sharedpreferences1.getString(Email, ""))
    }
}