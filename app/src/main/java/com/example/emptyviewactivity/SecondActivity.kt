package com.example.emptyviewactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.i("MyTag", "SecondActivity: OnCreate")
        setContentView(R.layout.activity_second)

        val btnBack = findViewById<Button>(R.id.btnBack)

        val textView = findViewById<TextView>(R.id.textView)

        textView.text = intent.getStringExtra("Name")

        btnBack.setOnClickListener {
            Log.i("MyTag","Back Clicked")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("MyTag", "SecondActivity: OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MyTag", "SecondActivity: OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MyTag", "SecondActivity: OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MyTag", "SecondActivity: OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MyTag", "SecondActivity: OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MyTag", "SecondActivity: OnRestart")
    }
}