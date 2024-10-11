package com.example.emptyviewactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MyTag", "MainActivity: OnCreate")

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            Log.i("MyTag", "Submit Clicked")
            val intent = Intent(this, SecondActivity::class.java)
            val etName = findViewById<EditText>(R.id.etName)
            var nameText = etName.text.toString()
            intent.putExtra("Name", nameText)
            Log.i("MyTag", "Name is $nameText")
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
        Log.i("MyTag", "MainActivity: OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MyTag", "MainActivity: OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MyTag", "MainActivity: OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MyTag", "MainActivity: OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MyTag", "MainActivity: OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MyTag", "MainActivity: OnRestart")
    }
}