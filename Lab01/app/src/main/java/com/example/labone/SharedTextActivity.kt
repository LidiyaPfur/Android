package com.example.labone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SharedTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_text)
        findViewById<TextView>(R.id.sharedText).text =
            intent.extras?.getString(MainActivity.SHARED_TEXT)
    }
}