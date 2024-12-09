package com.example.radiobutton_history

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Question_6 : AppCompatActivity() {
    private lateinit var radioGroupRB: RadioGroup
    private lateinit var buttonBTNTV: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        radioGroupRB = findViewById(R.id.radionGroupRB)
        buttonBTNTV = findViewById(R.id.buttonBTNTV2)

        var counterValue = intent.getIntExtra("Счетчик", 0)
        buttonBTNTV.setOnClickListener {
            val selectedId = radioGroupRB.checkedRadioButtonId
            if(selectedId != -1){
                val selectedRadio = findViewById<RadioButton>(selectedId)

                when(selectedId){
                    R.id.oneRB ->{
                        if(selectedRadio.text == "a) Война за независимость"){
                            counterValue += 0
                        }
                    }
                    R.id.twoRB -> {
                        if (selectedRadio.text == "b) Война, в которой Россия воевала с Османской империей") {
                            counterValue += 0
                        }
                    }
                    R.id.threeRB -> {
                        if (selectedRadio.text == "c) Война, в которой Россия участвовала в составе Антанты против центральных держав") {
                            counterValue += 100
                        }
                    }
                    R.id.fourRB -> {
                        if (selectedRadio.text == "d) Война с Японией") {
                            counterValue += 0
                        }
                    }
                }

                val nextIntent = Intent(this, SecondActivity::class.java)
                nextIntent.putExtra("Счетчик", counterValue)
                startActivity(nextIntent)
                finish()


            }else{
                Toast.makeText(this, "Выберите ответ", Toast.LENGTH_LONG).show()
            }

        }


    }


}