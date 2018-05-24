package me.luisguerra495.login

import java.io.Serializable

data class User(val id:Int, var nombre:String, var username:String, var email:String, var password:String) : Serializable