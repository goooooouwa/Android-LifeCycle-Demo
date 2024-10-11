package com.example.emptyviewactivity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var sf:SharedPreferences
    private lateinit var sfEditor:SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MyTag", "MainActivity: OnCreate")

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etHeight)
        etAge = findViewById(R.id.etHeight)
        sf = getSharedPreferences("mySP", MODE_PRIVATE)
        sfEditor = sf.edit()

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            Log.i("MyTag", "Submit Clicked")
            val intent = Intent(this, SecondActivity::class.java)
            val nameText = etName.text.toString()
            val age = etAge.text.toString().toInt()
            intent.putExtra("Name", nameText)
            intent.putExtra("Age", age)
            Log.i("MyTag", "Name is $nameText, I'm $age years old.")
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
        val nameText = sf.getString("spName", null)
        val age = sf.getInt("spAge",0)
        etName.setText(nameText)
        if(age!=0){
            etAge.setText(age.toString())
        }
    }

    override fun onPause() {
        super.onPause()
        Log.i("MyTag", "MainActivity: OnPause")
        val nameText = etName.text.toString()
        val age = etAge.text.toString().toInt()
        sfEditor.apply {
            putString("spName", nameText)
            putInt("spAge", age)
            commit()
        }
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