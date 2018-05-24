package me.luisguerra495.login

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import kotlin.properties.Delegates

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setTitle("Registro")

        var dbHelper: DBHelper by Delegates.notNull()
        var db: SQLiteDatabase by Delegates.notNull()

        dbHelper = DBHelper(this)
        db = dbHelper.writableDatabase

        btnRegister.setOnClickListener {
            val nombre = txtNombre.text
            val username = txtUsername.text
            val email = txtEmail.text
            val password = txtPassword.text

            val values = ContentValues()
            values.put("nombre", nombre.toString())
            values.put("username", username.toString())
            values.put("email", email.toString())
            values.put("password", password.toString())

            db.insert("users", null, values)

            Toast.makeText(getApplicationContext(), "Registrado correctamente!", Toast.LENGTH_SHORT).show()

            txtNombre.text.clear()
            txtUsername.text.clear()
            txtEmail.text.clear()
            txtPassword.text.clear()


            val intent = Intent(this, UsersActivity::class.java)

            val user = User(0, nombre.toString(), username.toString(), email.toString(), password.toString())

            intent.putExtra("user", user)

            startActivity(intent)

            finish()

        }
    }
}
