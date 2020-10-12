package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.R
import id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.data.Question
import id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.replaceFragment(FrontPageFragment())
    }

     // Extension function to replace fragment
    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.constraintHome, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}