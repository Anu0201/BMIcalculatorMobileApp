package com.cscorner.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    // Track values
    var height = 150
    var weight = 60
    var age = 26
    var isMale = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardMale = findViewById<CardView>(R.id.cardMale)
        val cardFemale = findViewById<CardView>(R.id.cardFemale)
        val tvHeight = findViewById<TextView>(R.id.tvHeight)
        val tvWeight = findViewById<TextView>(R.id.tvWeight)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val seekBar = findViewById<SeekBar>(R.id.seekBarHeight)
        val btnWeightMinus = findViewById<Button>(R.id.btnWeightMinus)
        val btnWeightPlus = findViewById<Button>(R.id.btnWeightPlus)
        val btnAgeMinus = findViewById<Button>(R.id.btnAgeMinus)
        val btnAgePlus = findViewById<Button>(R.id.btnAgePlus)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)

        seekBar.progress = height - 100

        // Huis songoh
        cardMale.setOnClickListener {
            isMale = true
            cardMale.setCardBackgroundColor(0xFF2C2F5B.toInt())
            cardFemale.setCardBackgroundColor(0xFF252538.toInt())
        }
        cardFemale.setOnClickListener {
            isMale = false
            cardFemale.setCardBackgroundColor(0xFF2C2F5B.toInt())
            cardMale.setCardBackgroundColor(0xFF252538.toInt())
        }

        // Undur
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                height = 100 + progress
                tvHeight.text = height.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        // Jin
        btnWeightMinus.setOnClickListener {
            if (weight > 1) {
                weight--
                tvWeight.text = weight.toString()
            }
        }

        btnWeightPlus.setOnClickListener {
            weight++
            tvWeight.text = weight.toString()
        }

        // Nas
        btnAgeMinus.setOnClickListener {
            if (age > 1) {
                age--
                tvAge.text = age.toString()
            }
        }

        btnAgePlus.setOnClickListener {
            age++
            tvAge.text = age.toString()
        }

        // Calculate
        btnCalculate.setOnClickListener {
            val heightInM = height / 100.0
            val bmi = weight / (heightInM * heightInM)

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("BMI_VALUE", bmi)
            startActivity(intent)
        }
    }
}