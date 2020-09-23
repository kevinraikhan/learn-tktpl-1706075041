package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.R
import kotlinx.android.synthetic.main.lab2_activity.*

// Basic Calculator
class Lab2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lab2_activity)
        buttonPlus.setOnClickListener {
            textViewResult.text = add(editTextFirstNumber.text.toString(), editTextSecondNumber.text.toString())
        }

        buttonMinus.setOnClickListener {
            textViewResult.text = subtract(editTextFirstNumber.text.toString(), editTextSecondNumber.text.toString())
        }

        buttonMultiply.setOnClickListener {
            textViewResult.text = multiply(editTextFirstNumber.text.toString(), editTextSecondNumber.text.toString())
        }

        buttonDivide.setOnClickListener {
            textViewResult.text = divide(editTextFirstNumber.text.toString(), editTextSecondNumber.text.toString())
        }
    }

    fun add(a: String, b: String): String {
        return ((a.toDoubleOrNull() ?: 0.0) + (b.toDoubleOrNull() ?: 0.0)).toString()
    }

    fun subtract(a: String, b: String): String {
        return ((a.toDoubleOrNull() ?: 0.0) - (b.toDoubleOrNull() ?: 0.0)).toString()
    }

    fun multiply(a: String, b: String): String {
        return ((a.toDoubleOrNull() ?: 0.0) * (b.toDoubleOrNull() ?: 0.0)).toString()
    }

    fun divide(a: String, b: String): String {
        return ((a.toDoubleOrNull() ?: 0.0) / (b.toDoubleOrNull() ?: 0.0)).toString()
    }
}