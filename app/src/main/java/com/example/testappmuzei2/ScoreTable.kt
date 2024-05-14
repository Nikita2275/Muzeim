package com.example.testappmuzei2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreTable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_table)

        val back : Button = findViewById(R.id.backk)

        back.setOnClickListener{
            val intent: Intent = Intent(this, TestSelect::class.java)
            startActivity(intent)
            finish()
        }
    }
}