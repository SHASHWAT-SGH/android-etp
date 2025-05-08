package com.example.etppractice.unit5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.etppractice.R
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException

class ExternalDetails : AppCompatActivity() {
    lateinit var fstream: FileInputStream
    private val filename = "SampleFile.txt"
    private val filepath = "MyFileStorage"
    lateinit var myExternalFile: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_external_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result = findViewById<TextView>(R.id.resultView)
        val back = findViewById<Button>(R.id.btnBack)
        try {
            myExternalFile = File(getExternalFilesDir(filepath), filename)
            fstream = FileInputStream(myExternalFile)

            val details = fstream.bufferedReader().use {
                it.readText()
            }.split("\n")

            result.text = """
                Name: "${details[0]}"
                Password: ${details[1]}
                """.trimIndent()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        back.setOnClickListener {
            intent = Intent(this, ExternalStorageActivity::class.java)
            startActivity(intent)
        }
    }
}