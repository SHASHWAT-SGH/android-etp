package com.example.etppractice.unit5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.etppractice.R
import java.io.IOException

class InternalStorageActivity : AppCompatActivity() {
    private lateinit var etStudentName: EditText
    private lateinit var etGrade: EditText
    private val fileName = "student_grades.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_internal_storage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etStudentName = findViewById(R.id.etStudentName)
        etGrade = findViewById(R.id.etGrade)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnLoad = findViewById<Button>(R.id.btnLoad)
        val btnClear = findViewById<Button>(R.id.btnClear)
        btnSave.setOnClickListener { saveGrade() }
        btnLoad.setOnClickListener { loadGrade() }
        btnClear.setOnClickListener { clearFields() }
    }

    private fun saveGrade() {
        val name = etStudentName.text.toString()
        val grade = etGrade.text.toString()

        if (name.isEmpty() || grade.isEmpty()) {
            Toast.makeText(this, "Please enter both name and grade", Toast.LENGTH_SHORT).show()
            return
        }
        val data = "$name\n$grade"
        try {
            openFileOutput(fileName, MODE_PRIVATE).use {
                it.write(data.toByteArray())
            }
            Toast.makeText(this, "Grade saved to internal storage", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Error saving grade", Toast.LENGTH_SHORT).show()
        }
    }
    private fun loadGrade() {
        openFileInput(fileName).use { stream ->
            val lines = stream.bufferedReader().readLines()
            if (lines.size >= 2) {
                etStudentName.setText(lines[0])
                etGrade.setText(lines[1])
                Toast.makeText(this, "Grade loaded", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No data to load", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun clearFields() {
        etStudentName.setText("")
        etGrade.setText("")
    }
}