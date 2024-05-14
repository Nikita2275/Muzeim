package com.example.testappmuzei2

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Authorezacia : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorezacia)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val userLogin : EditText = findViewById(R.id.user_login_auth)
        val userPass : EditText = findViewById(R.id.user_pass_auth)
        val button : Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        linkToReg.setOnClickListener{
            val intent = Intent(this, Registracia::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userLogin.text.toString().trim()

            if (login == "" ||  pass == "") {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
            }
            else {

                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)

                if(isAuth ){
                    Toast.makeText(this, "Пользователь $login авторизован", Toast.LENGTH_SHORT).show()
                    userLogin.text.clear()
                    userPass.text.clear()
                    val intent = Intent(this, TestSelect::class.java)
                    startActivity(intent)
                }
                else
                    Toast.makeText(this, "Пользователь $login не авторизован", Toast.LENGTH_SHORT).show()
            }
        }
    }
}