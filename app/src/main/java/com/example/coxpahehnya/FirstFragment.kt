package com.example.coxpahehnya

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val editText = view.findViewById<EditText>(R.id.editText)
        val buttonSend = view.findViewById<Button>(R.id.buttonSend)

        buttonSend.setOnClickListener {
            val text = editText.text.toString()
            val bundle = Bundle()
            bundle.putString("inputText", text)

            val secondFragment = SecondFragment()
            secondFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, secondFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}