package com.example.radiobutton_history

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var counter = 0
    private lateinit var buttonBTN:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        buttonBTN = findViewById(R.id.buttonBTN)
        buttonBTN.setOnClickListener {
        val intent = Intent(this, Question_2::class.java)
            intent.putExtra("", counter)
            startActivity(intent)
            Toast.makeText(this,"Начало теста по Истории. "
                    +"$counter",
            Toast.LENGTH_LONG).show()
    }
    }
}