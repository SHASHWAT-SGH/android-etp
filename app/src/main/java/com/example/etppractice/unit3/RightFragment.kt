package com.example.etppractice.unit3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.etppractice.R

class RightFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_right, container, false)
        layout.findViewById<Button>(R.id.btn_right).setOnClickListener {
            val leftFragment = parentFragmentManager.findFragmentById(R.id.frame_left) as LeftFragment
            leftFragment.transferData("Data from Right Frag")
        }

        return layout
    }

    fun transferData(text: String) {
        val textView = view?.findViewById<TextView>(R.id.txt_view)
        textView?.text = text
    }

}