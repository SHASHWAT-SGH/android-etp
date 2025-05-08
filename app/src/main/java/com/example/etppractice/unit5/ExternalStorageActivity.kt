package com.example.etppractice.unit5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.etppractice.R
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class ExternalStorageActivity : AppCompatActivity() {
    lateinit var uname: EditText
    lateinit var pwd: EditText
    lateinit var saveBtn: Button
    lateinit var fstream: FileOutputStream
    private val filename = "SampleFile.txt"
    private val filepath = "MyFileStorage"
    lateinit var myExternalFile: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_external_storage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        uname = findViewById(R.id.txtName)
        pwd = findViewById(R.id.txtPwd)
        saveBtn = findViewById(R.id.btnSave)

        saveBtn.setOnClickListener {
            val username = uname.text.toString()
            val password = pwd.text.toString()
            try {
                if (username.isEmpty() || password.isEmpty())
                    Toast.makeText(this, "either of field is empty", Toast.LENGTH_SHORT).show()
                else {
                    myExternalFile = File(getExternalFilesDir(filepath), filename)
                    fstream = FileOutputStream(myExternalFile)
                    fstream.write(username.toByteArray())
                    fstream.write("\n".toByteArray())
                    fstream.write(password.toByteArray())
                    fstream.close()
                    Toast.makeText(applicationContext, "Details Saved in " + myExternalFile!!.absolutePath, Toast.LENGTH_LONG).show()
                    intent = Intent(this, ExternalDetails::class.java)
                    startActivity(intent)
                }
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}