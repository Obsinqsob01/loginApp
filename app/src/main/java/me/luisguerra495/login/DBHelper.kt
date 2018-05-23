package me.luisguerra495.login

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(context: Context) : SQLiteOpenHelper(context, "login.db", null, 1) {
    val TABLE = "users"

    companion object {
        public val ID = "_id"
        public var Nombre = "nombre"
        public var Username = "username"
        public var Email = "email"
        public var Password = "password"
    }

    val DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS ${TABLE}(" +
            "${ID} INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,${Nombre} varchar(50) NOT NULL,"+
            "${ Username} varchar(50) NOT NULL,"+
            "${Email} varchar(50) NOT NULL,"+
            "${ Password} varchar(50) NOT NULL);"

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}