package com.example.testappmuzei2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import java.util.Locale

class MainMenu : BaseActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private var isMusicPlaying = true
    private lateinit var imageButton: ImageButton
    lateinit var mBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        loadLocate()

        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer?.start()

        imageButton = findViewById(R.id.imageButton)
        imageButton.setOnClickListener {
            toggleMusic()
        }

        mBtn = findViewById(R.id.Lang_language)

        mBtn.setOnClickListener(){
            showChangeLang()
        }
    }

    override fun onStart() {
        super.onStart()
        if (isMusicPlaying) {
            mediaPlayer?.start()
        }
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private fun toggleMusic() {
        isMusicPlaying = !isMusicPlaying
        if (isMusicPlaying) {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.music)
                mediaPlayer?.isLooping = true
            }
            mediaPlayer?.start()
        } else {
            mediaPlayer?.pause()
        }
        updateMusicButtonImage()
    }

    private fun updateMusicButtonImage() {
        imageButton.setImageResource(
            if (isMusicPlaying) R.drawable.pause
            else R.drawable.play
        )
    }

    fun Registr_Click(view: View) {
        val intent: Intent = Intent(this, Authorezacia::class.java)
        startActivity(intent)
        finish()
    }

    fun Cencel(view: View) {
        finish()
    }

    private fun showChangeLang() {
        val listItems = arrayOf("Russian", "English")

        val mBuilder = AlertDialog.Builder(this@MainMenu)
        mBuilder.setTitle("Язык")
        mBuilder.setSingleChoiceItems(listItems,-1){ dialog, which ->
            if (which == 0){
                setLocate("ru")
                recreate()
            }
            else if(which == 1){
                setLocate("en")
                recreate()
            }

            dialog.dismiss()
        }
        val mDialig = mBuilder.create()

        mDialig.show()
    }

    private fun setLocate(Lang: String){
        val locale = Locale(Lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", Lang)
        editor.apply()
    }

    private fun loadLocate(){
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")
        if (language != null) {
            setLocate(language)
        }
    }
}