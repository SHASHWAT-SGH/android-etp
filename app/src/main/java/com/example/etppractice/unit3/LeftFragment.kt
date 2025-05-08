package com.example.etppractice.unit3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.etppractice.R

class LeftFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_left, container, false)
        layout.findViewById<Button>(R.id.btn_left).setOnClickListener {
            val text = layout.findViewById<EditText>(R.id.edit_txt).text.toString()

            val rightFragment = parentFragmentManager.findFragmentById(R.id.frame_right) as RightFragment

            rightFragment.transferData(text)

        }

        return layout
    }

    fun transferData(text: String) {
        val editText = view?.findViewById<EditText>(R.id.edit_txt)
        editText?.setText(text)

    }

}