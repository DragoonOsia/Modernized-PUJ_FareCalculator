package com.dreathseeker.modernizedpujfare

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val numberInput = findViewById<EditText>(R.id.dist)
        val discountCheckBox = findViewById<CheckBox>(R.id.discountCheckBox)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val inputText = numberInput.text.toString()

            if (inputText.isNotEmpty()) {
                val inputNumber = inputText.toFloat()
                var result: Float

                if (inputNumber <= 4) {
                    result = 15f
                } else {
                    result = 15f + (inputNumber - 4) * 2.20f
                }

                if (discountCheckBox.isChecked) {
                    result *= 0.8f
                }

                // Prefix the result with 'P'
                resultTextView.text = String.format("P%.2f", result)
            } else {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()
            }
        }
    }
}