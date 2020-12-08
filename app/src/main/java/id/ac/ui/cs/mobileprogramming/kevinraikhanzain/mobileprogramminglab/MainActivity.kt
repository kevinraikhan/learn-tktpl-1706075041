package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonHello.setOnClickListener {
            textViewTop.text = "Hello, ${editTextTextPersonName.text.toString()}"
        }
    }
}