package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


// Source :
// https://medium.com/@nabeelj/making-a-simple-get-and-post-request-using-volley-beginners-guide-ee608f10c0a9
// https://developer.android.com/training/volley/simple
// https://developer.android.com/guide/topics/connectivity/wifi-scan
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        val wifiScanReceiver = object : BroadcastReceiver() {

            override fun onReceive(context: Context, intent: Intent) {
                val success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)
                if (success) {
                    var result = ""
                    wifiManager.scanResults.forEach {
                        result += "[${it.SSID}]"
                    }
                    textViewListWifi.text = result
                } else {
                    textViewListWifi.text = "GAGAL"
                }
            }
        }
        val intentFilter = IntentFilter()
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        applicationContext.registerReceiver(wifiScanReceiver, intentFilter)

        buttonScanWifi.setOnClickListener {
            textViewListWifi.text = "Loading..."
            textViewResponse.text = "Loading..."


            val success = wifiManager.startScan()
            if (!success) {
                // scan failure handling
                textViewListWifi.text = "GAGAL Scan"
            }


            // Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(this)
            val url = "https://enbqkamr9ihu5.x.pipedream.net/"

            // Create JSON object
            val postJsonObj = JSONObject()
            postJsonObj.put("name", "Kevin Raikhan Zain")
            postJsonObj.put("npm", "1706075041")

            // Create JSON Object Request to request to requestbin
            val jsonReq = JsonObjectRequest(
                Request.Method.POST,
                url,
                postJsonObj,
                Response.Listener<JSONObject> { response ->
                    // Display the first 500 characters of the response string.
                    textViewResponse.text = "Response is: ${response.toString()}"
                },
                Response.ErrorListener { textViewResponse.text = "That didn't work!" })

            // Add the request to the RequestQueue.
            queue.add(jsonReq)


        }
    }
}