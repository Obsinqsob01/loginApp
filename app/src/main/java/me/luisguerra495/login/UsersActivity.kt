package me.luisguerra495.login

import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_users.*
import kotlin.properties.Delegates

class UsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        var dbHelper: DBHelper by Delegates.notNull()
        var db: SQLiteDatabase by Delegates.notNull()

        dbHelper = DBHelper(this)
        db = dbHelper.writableDatabase

        val user = getIntent().getSerializableExtra("user")
        val users = dbHelper.getUsers()

        var usersAdapter = UserAdapter(users)
        listViewUsers.adapter = usersAdapter
    }

    inner class UserAdapter : BaseAdapter {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        }

        override fun getItem(position: Int): Any {
            return listUsersAdapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listUsersAdapter.size
        }

        var listUsersAdapter = ArrayList<User>()

        constructor(listUsers: ArrayList<User>): super() {
            this.listUsersAdapter = listUsers
        }
    }
}
