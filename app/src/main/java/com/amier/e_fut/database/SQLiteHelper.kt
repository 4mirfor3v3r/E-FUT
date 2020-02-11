package com.amier.e_fut.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(val context: Context):SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {
    companion object{
        const val DB_NAME = "lapangan"
        const val DB_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = ""
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}