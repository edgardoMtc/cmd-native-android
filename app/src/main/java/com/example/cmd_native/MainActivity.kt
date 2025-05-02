package com.example.cmd_native

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.view.View
import android.widget.Toast

// import androidx.core.text.set


class MainActivity : AppCompatActivity() {
    private lateinit var rdFromKm: RadioButton
    private lateinit var rdFromMiles: RadioButton
    private lateinit var textValue: EditText
    private lateinit var textResult: EditText
    private lateinit var appContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rdFromKm = findViewById(R.id.rbKm)
        rdFromMiles = findViewById(R.id.rbMiles)
        textValue = findViewById(R.id.textValue)
        textResult = findViewById(R.id.textResult)
    }

    fun handleClick(view: View) {
        when (view.id) {
            (R.id.buttonConvert) -> {
               val value = textValue.text.toString()
                if (value.isEmpty()) {
                    val context = appContext.applicationContext
                    val errorText = "Error: Empty value!"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(context, errorText, duration)
                    toast.show()

                } else {
                    val result: String = if (rdFromKm.isChecked) {
                        kmToMiles(value)
                    } else {
                        milesToKM(value)
                    }
                    textResult.setText(result)
                }
            }

            (R.id.buttonReset) -> {
                rdFromKm.isChecked = false
                rdFromMiles.isChecked = false
                textValue.text.clear()
                textResult.text.clear()
            }
        }
    }

    private fun milesToKM(miles: String): String {
        val mValue = miles.toDouble()
        val kmValue = mValue * 1.609
        return kmValue.toString()
    }

    private fun kmToMiles(km: String): String {
        val kValue = km.toDouble()
        val mValue = kValue / 1.609
        return mValue.toString()
    }
}