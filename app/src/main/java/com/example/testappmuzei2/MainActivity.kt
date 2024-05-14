package com.example.testappmuzei2

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 3500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        Handler().postDelayed({
            val intent: Intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)

        val textView = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_anim)
        textView.startAnimation(fadeInAnimation)
        textView2.startAnimation(fadeInAnimation)
    }
}