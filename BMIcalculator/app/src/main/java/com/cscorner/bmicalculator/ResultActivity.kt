package com.cscorner.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val bmiText = findViewById<TextView>(R.id.tvBMI)
        val categoryText = findViewById<TextView>(R.id.tvCategory)
        val messageText = findViewById<TextView>(R.id.tvMessage)
        val backBtn = findViewById<Button>(R.id.btnBack)

        // BMI utga
        val bmi = intent.getDoubleExtra("BMI_VALUE", 0.0)
        bmiText.text = String.format("%.1f", bmi)

        if (bmi < 18.5) {
            categoryText.text = "Хэвийн жингээс бага"
            messageText.text  = "Таны жин хэвийн хэмжээнээс бага байна."
        } else if (bmi < 25.0) {
            categoryText.text = "Хэвийн"
            messageText.text  = "Таны биеийн жин хэвийн байна."
        } else if (bmi < 30.0) {
            categoryText.text = "Жингийн илүүдэлтэй"
            messageText.text  = "Таны жин хэвийн хэмжээнээс өндөр байна."
        } else {
            categoryText.text = "Таргалалттай"
            messageText.text  = "Таны биеийн жин их байна."
        }

        backBtn.setOnClickListener {
            finish()
        }
    }
}