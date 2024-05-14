package com.example.testappmuzei2

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Select_woman : AppCompatActivity() {
    private var currentIndex = 0
    private val images = arrayOf(
        R.drawable.woman1,
        R.drawable.woman2,
        R.drawable.woman3
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_select_woman)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val leftButton = findViewById<ImageButton>(R.id.imageButton2)
        val rightButton = findViewById<ImageButton>(R.id.imageButton1)

        leftButton.setOnClickListener {
            currentIndex = (currentIndex - 1 + images.size) % images.size
            updateImage()
        }

        rightButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % images.size
            updateImage()
        }
    }

    private fun updateImage() {
        findViewById<ImageView>(R.id.imageView1).setImageResource(images[currentIndex])
        findViewById<ImageView>(R.id.imageView2).visibility = View.INVISIBLE
        findViewById<ImageView>(R.id.imageView3).visibility = View.INVISIBLE
    }

    fun Forward(view: View) {
        val intent: Intent = Intent(this, TestSelect::class.java)
        startActivity(intent)
        finish()
    }
}