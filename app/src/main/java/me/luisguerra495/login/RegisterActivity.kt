package me.luisguerra495.login

import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlin.properties.Delegates

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var dbHelper: DBHelper by Delegates.notNull()
        var db: SQLiteDatabase by Delegates.notNull()

        dbHelper = DBHelper(this)
        db = dbHelper.writableDatabase

        val query = "INSERT INTO users('1', 'luis', 'luisguerra495', 'luisguerra495@gmail.com', 'pass')"

        db.execSQL(query)
    }
}
