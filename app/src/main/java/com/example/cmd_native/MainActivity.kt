package com.example.cmd_native

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private RadioButton rdFromKm
    private RadioButton rdFromMiles
    private EditText textValue
    private EditText textResult

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rdFromKm = findViewById<Boolean>(R.id.rbKm)
    }
}