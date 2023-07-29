package com.example.start_app_hw_ultrapro


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var batteryLevelTextView: TextView

    private val batteryReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val batteryLevel: Int? = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            batteryLevelTextView.text = "Battery Level: $batteryLevel%"
        }
    }

    override fun onCreate(bublic4: Bundle?) {
        super.onCreate(bublic4)
        setContentView(R.layout.activity_main)

        batteryLevelTextView = findViewById(R.id.battery_level_textview)
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(batteryReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(batteryReceiver)
    }
}
