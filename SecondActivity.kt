package com.example.radiobutton_history

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class SecondActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private lateinit var ratingTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        resultTextView = findViewById(R.id.resultTextView)
        ratingTextView = findViewById(R.id.ratingTextView)


        val score = intent.getIntExtra("Счетчик", 0)


        resultTextView.text = "Ваши очки: $score"
        ratingTextView.text = getRating(score)
    }

    private fun getRating(score: Int): String {
        return when {
            score == 500 -> "Отличный знаток"
            score >= 400 -> "Хороший знаток"
            score >= 300 -> "Удовлетворительный знаток"
            score >= 200 -> "Неплохой знаток"
            else -> "Плохой знаток"
        }
    }
}