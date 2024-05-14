package com.example.testappmuzei2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper1(val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "appp", factory, 1) {

        override fun onCreate(db: SQLiteDatabase?) {
            val query = "CREATE TABLE userss (id INT PRIMARY KEY,score TEXT)"
            db!!.execSQL(query)
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS userss")
            onCreate(db)
        }

        fun addScore(userss: Users){
            val values = ContentValues()
            values.put("score", userss.score)

            val db = this.writableDatabase
            db.insert("userss", null, values)

            db.close()
        }

        fun getScore(login: String ,score: String): Boolean{
            val db = this.readableDatabase

            val result = db.rawQuery("SELECT * FROM userss WHERE pass = '$score'", null)
            return result.moveToFirst()
        }
}