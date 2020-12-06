package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            if (!editTextNumber.text.isNullOrEmpty()) {
                var number = editTextNumber.text.toString().toInt()
                textViewResult.text = Method(number).toString()
            }
        }
    }

    external fun Method(number: Int): Int

    companion object {
        init {
            System.loadLibrary("cpp_code")
        }
    }
}