package com.chibufirst.userinput

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputTextView: TextView = findViewById(R.id.inputTextView)
        val inputTextField: TextInputLayout = findViewById(R.id.inputTextField)
        inputTextField.editText?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

            override fun afterTextChanged(p0: Editable?) { }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0?.isNotEmpty()!!) inputTextField.error = null
            }
        })
        findViewById<Button>(R.id.inputButton)
            .setOnClickListener {
                inputTextField.apply {
                    if (editText?.text.isNullOrEmpty()) {
                        error = "Field required"
                        requestFocus()
                    } else {
                        error = null
                        inputTextView.text = editText?.text.toString()
                    }
                }
            }
    }
}