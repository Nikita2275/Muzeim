package com.example.testappmuzei2

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Registracia : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registracia)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val userLogin : EditText = findViewById(R.id.user_login)
        val userEmail : EditText = findViewById(R.id.user_email)
        val userPass : EditText = findViewById(R.id.user_pass)
        val button : Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener{
            val intent = Intent(this, Authorezacia::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val email = userLogin.text.toString().trim()
            val pass = userLogin.text.toString().trim()

            if(login == "" || email == "" || pass == ""){
                Toast.makeText(this,"Не все поля заполнены", Toast.LENGTH_SHORT).show()
            }
            else{
                val user = User(login, email, pass)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this,"Пользователь $login добавлен", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Select_pol::class.java)
                startActivity(intent)

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
            }
        }
    }
}