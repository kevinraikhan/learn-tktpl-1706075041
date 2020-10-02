package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Thread.sleep

// Stopwatch app
class MainActivity : AppCompatActivity() {
    var isExitPressed: Boolean = false
    var isPaused: Boolean = true
    var minute: Int = 0
    var second: Int = 0

    // Timer logic runnable to run in new thread
    var timerRunnable: Runnable = Runnable {
        // Try catch to handle thread interruption
        try {
            // Infinite loop to infinitely increment timer
            while (true) {
                // Wait 1 second
                sleep(1000)
                // Update the ui on UI Thread
                runOnUiThread {
                    second++
                    if (second == 60) {
                        minute++
                        second = 0
                    }
                    val minuteString = if (minute.toString().length > 1) "$minute" else "0$minute"
                    val secondString = if (second.toString().length > 1) "$second" else "0$second"

                    textViewTimeCounter.text = "$minuteString:$secondString"
                }
            }
        } catch (e: InterruptedException) { // Catch the interrupt exception
            println("Thread Interrupted")
        }
    }

    // new Thread attribute
    lateinit var timerThread: Thread

    // override android lifecycle to log when state changes
    override fun onRestart() {
        super.onRestart()
        Log.d("LOGNYA", "onRestart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LOGNYA", "onResume()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LOGNYA", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LOGNYA", "onDestroy()")
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Press EXIT to exit", Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d("LOGNYA", "onStart()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("LOGNYA", "onCreate()")

        // Exit button to exit the app
        buttonExit.setOnClickListener {
            if (isExitPressed) { // Button exit is pressed twice
                isExitPressed = false
                super.onBackPressed() // Use back button logic to exit the app
            } else { // Button exit only pressed once
                Toast.makeText(this, "Press twice to exit", Toast.LENGTH_LONG).show()
                isExitPressed = true
            }
        }

        buttonReset.setOnClickListener {
            minute = 0
            second = 0
            if (!isPaused) { // Interrupt timer when reset stopwatch is pressed
                timerThread.interrupt()
                buttonStartPause.text = "Start"
                isPaused = true
            }
            textViewTimeCounter.text = "00:00"
        }

        buttonStartPause.setOnClickListener {
            if (isPaused) { // Start new timer thread when start is pressed
                isPaused = false
                buttonStartPause.text = "Pause"
                timerThread = Thread(timerRunnable)
                timerThread.start()
            } else { // Interrupt timer when pause stopwatch is pressed
                isPaused = true
                buttonStartPause.text = "Start"
                timerThread.interrupt()
            }
        }
    }
}