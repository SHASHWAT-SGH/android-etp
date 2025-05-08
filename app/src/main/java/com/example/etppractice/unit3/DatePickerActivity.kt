package com.example.etppractice.unit3

import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.etppractice.R

class DatePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_date_picker)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val datePicker = findViewById<DatePicker>(R.id.date_picker)
        val btnPickDate = findViewById<Button>(R.id.btn_pick_date)
        val txtViewDate = findViewById<TextView>(R.id.txt_view_date)

        btnPickDate.setOnClickListener {
            val day = datePicker.dayOfMonth
            val month = datePicker.month
            val year = datePicker.year
            txtViewDate.text = "$day/$month/$year"
        }
    }
}