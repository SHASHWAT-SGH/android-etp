package com.example.etppractice.unit3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.etppractice.R

class TimePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_time_picker)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn = findViewById<Button>(R.id.btn)
        val txt = findViewById<TextView>(R.id.txt)
        val timePicker = findViewById<TimePicker>(R.id.time_picker)

        btn.setOnClickListener {
            val hour = timePicker.hour
            val minute = timePicker.minute
            val ampm = if (timePicker.hour >= 12) "PM" else "AM"
            txt.text = "$hour:$minute $ampm"
        }
    }
}