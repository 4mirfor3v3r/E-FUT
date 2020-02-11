package com.amier.e_fut.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.amier.e_fut.model.Users

class SQLiteHelper(val context: Context):SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {
    companion object{
        const val DB_NAME = "lapangan"
        const val DB_VERSION = 1
        const val TABLE_NAME = "users"

        const val COLUMN_UID = "uid"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PASSWORD = "password"
        const val COLUMN_NAME = "name"
        const val NO_TELP = "telp"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_UID INTEGER PRIMARY KEY," +
                "$COLUMN_NAME TEXT," +
                "$COLUMN_EMAIL TEXT," +
                "$COLUMN_PASSWORD TEXT," +
                "$NO_TELP TEXT);"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val dropTable = "DROP TABLE IF EXISTS $TABLE_NAME;"
        db.execSQL(dropTable)
        onCreate(db)
    }

    fun addData(data: Users): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NAME, data.COLUMN_NAME)
        values.put(COLUMN_EMAIL, data.COLUMN_EMAIL)
        values.put(COLUMN_PASSWORD, data.COLUMN_PASSWORD)
        values.put(NO_TELP, data.NO_TELP)

        val success = db.insert(TABLE_NAME, null, values)
        db.close()
        Log.e("INSERTED ID", "$success")
        return (Integer.parseInt("$success") != -1)
    }
    fun verify(email:String,password:String):Boolean{
        val a:Boolean
        val db = this.writableDatabase
        val sql = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_EMAIL= '$email' AND $COLUMN_PASSWORD = '$password'"
        val cursor =  db.rawQuery(sql,null)
        a = cursor != null && cursor.moveToFirst()
        cursor.close()
        return a
    }
}