package me.luisguerra495.login

import android.content.Context
import android.database.Cursor
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
//        db!!.execSQL("DROP TABLE users")
        db!!.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun getUsers(): ArrayList<User> {
        val db = this.writableDatabase
        val list = ArrayList<User>()

        val cursor: Cursor

        cursor = db.rawQuery("SELECT * FROM users", null)

        if(cursor != null) {
            if(cursor.count > 0) {
                cursor.moveToFirst()

                do {
                    val id = cursor.getInt(cursor.getColumnIndex("_id"))
                    val nombre = cursor.getString(cursor.getColumnIndex("nombre"))
                    val username = cursor.getString(cursor.getColumnIndex("username"))
                    val email = cursor.getString(cursor.getColumnIndex("email"))
                    val password = cursor.getString(cursor.getColumnIndex("password"))

                    val user = User(id, nombre, username, email, password)
                    list.add(user)
                } while(cursor.moveToNext())
            }
        }
        return list
    }

}