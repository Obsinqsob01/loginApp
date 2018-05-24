package me.luisguerra495.login

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.content_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        setSupportActionBar(toolbar)

        val user = getIntent().getSerializableExtra("user") as User

        toolbar_layout.title = user.nombre

        txtUsernameUser.text = user.username
        txtEmailUser.text = user.email
        txtPasswordUser.text = user.password
    }
}
