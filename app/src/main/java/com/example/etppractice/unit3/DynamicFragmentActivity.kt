package com.example.etppractice.unit3

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.etppractice.R

class DynamicFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dynamic_fragment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn = findViewById<Button>(R.id.btn)
        var isFirst = true

        btn.setOnClickListener {
            if (isFirst) {
                loadFragment(Dynamic1Fragment())
            } else {
                loadFragment(Dynamic2Fragment())
            }

            isFirst = !isFirst
        }
    }

    private fun loadFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val change = fragmentManager.beginTransaction()
        change.replace(R.id.fragment_container, fragment)
        change.commit()
    }
}