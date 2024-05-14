package com.example.testappmuzei2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class TestSelect : BaseActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private var isMusicPlaying = true
    private lateinit var imageButton: ImageButton
    lateinit var mBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test_select)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        loadLocate()

        imageButton = findViewById(R.id.imageButton)
        imageButton.setOnClickListener {
            toggleMusic()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textView1 = findViewById<TextView>(R.id.Text); val textView2 = findViewById<TextView>(R.id.Text1); val textView3 = findViewById<TextView>(R.id.Text2); val textView4 = findViewById<TextView>(R.id.Text3); val textView5 = findViewById<TextView>(R.id.Text4); val textView6 = findViewById<TextView>(R.id.Text5); val textView7 = findViewById<TextView>(R.id.Text6); val textView8 = findViewById<TextView>(R.id.Text7);
        val imageView16 = findViewById<ImageView>(R.id.images1); val imageView17 = findViewById<ImageView>(R.id.images2); val imageView18 = findViewById<ImageView>(R.id.images3); val imageView19 = findViewById<ImageView>(R.id.images4); val imageView20 = findViewById<ImageView>(R.id.images5); val imageView21 = findViewById<ImageView>(R.id.images6); val imageView22 = findViewById<ImageView>(R.id.images7); val imageView23 = findViewById<ImageView>(R.id.images8);
        val textView = findViewById<TextView>(R.id.Title); val imageView = findViewById<ImageView>(R.id.border); val imageView1 = findViewById<ImageView>(R.id.border1); val imageView2 = findViewById<ImageView>(R.id.border2); val imageView3 = findViewById<ImageView>(R.id.border3); val imageView4 = findViewById<ImageView>(R.id.border4); val imageView5 = findViewById<ImageView>(R.id.border5); val imageView6 = findViewById<ImageView>(R.id.border6); val imageView7 = findViewById<ImageView>(R.id.border7); val imageView8 = findViewById<ImageView>(R.id.border8); val imageView9 = findViewById<ImageView>(R.id.border9); val imageView10 = findViewById<ImageView>(R.id.border10); val imageView11 = findViewById<ImageView>(R.id.border11); val imageView12 = findViewById<ImageView>(R.id.border12); val imageView13 = findViewById<ImageView>(R.id.border13); val imageView14 = findViewById<ImageView>(R.id.border14); val imageView15 = findViewById<ImageView>(R.id.border15);
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_anim_select)
        textView.startAnimation(fadeInAnimation); imageView.startAnimation(fadeInAnimation); imageView1.startAnimation(fadeInAnimation); imageView2.startAnimation(fadeInAnimation); imageView3.startAnimation(fadeInAnimation); imageView4.startAnimation(fadeInAnimation); imageView5.startAnimation(fadeInAnimation); imageView6.startAnimation(fadeInAnimation); imageView7.startAnimation(fadeInAnimation); imageView8.startAnimation(fadeInAnimation); imageView9.startAnimation(fadeInAnimation); imageView10.startAnimation(fadeInAnimation); imageView11.startAnimation(fadeInAnimation); imageView12.startAnimation(fadeInAnimation); imageView13.startAnimation(fadeInAnimation); imageView14.startAnimation(fadeInAnimation); imageView15.startAnimation(fadeInAnimation)
        imageView16.startAnimation(fadeInAnimation); imageView17.startAnimation(fadeInAnimation); imageView18.startAnimation(fadeInAnimation); imageView19.startAnimation(fadeInAnimation); imageView20.startAnimation(fadeInAnimation); imageView21.startAnimation(fadeInAnimation); imageView22.startAnimation(fadeInAnimation); imageView23.startAnimation(fadeInAnimation);
        textView1.startAnimation(fadeInAnimation); textView2.startAnimation(fadeInAnimation); textView3.startAnimation(fadeInAnimation); textView4.startAnimation(fadeInAnimation); textView5.startAnimation(fadeInAnimation); textView6.startAnimation(fadeInAnimation); textView7.startAnimation(fadeInAnimation); textView8.startAnimation(fadeInAnimation);

        mBtn = findViewById(R.id.language)

        mBtn.setOnClickListener(){
            showChangeLang()
        }
    }

    private fun toggleMusic() {
        isMusicPlaying = !isMusicPlaying
        if (!isMusicPlaying) {
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

    private fun updateMusicButtonImage() {
        imageButton.setImageResource(
            if (isMusicPlaying) R.drawable.play
            else R.drawable.pause
        )
    }

    fun Muzei1(view: View) {
        val intent: Intent = Intent(this, Muzei1::class.java)
        startActivity(intent)
        finish()
    }

    fun Muzei2(view: View) {
        val intent: Intent = Intent(this, Muzei2::class.java)
        startActivity(intent)
        finish()
    }

    fun Muzei3(view: View) {
        val intent: Intent = Intent(this, Muzei3::class.java)
        startActivity(intent)
        finish()
    }

    fun Muzei4(view: View) {
        val intent: Intent = Intent(this, Muzei4::class.java)
        startActivity(intent)
        finish()
    }

    fun Muzei5(view: View) {
        val intent: Intent = Intent(this, Muzei5::class.java)
        startActivity(intent)
        finish()
    }
    fun Muzei8(view: View) {
        val intent: Intent = Intent(this, Muzei8::class.java)
        startActivity(intent)
        finish()
    }
    fun Muzei7(view: View) {
        val intent: Intent = Intent(this, Muzei7::class.java)
        startActivity(intent)
        finish()
    }
    fun Muzei6(view: View) {
        val intent: Intent = Intent(this, Muzei6::class.java)
        startActivity(intent)
        finish()
    }
    fun Reiting(view: View) {
        val intent: Intent = Intent(this, ScoreTable::class.java)
        startActivity(intent)
        finish()
    }

    private fun showChangeLang() {
        val listItems = arrayOf("Russian", "English")

        val mBuilder = AlertDialog.Builder(this@TestSelect)
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