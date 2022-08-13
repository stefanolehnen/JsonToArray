package com.example.jsonproject

data class UserModel(val name:String, val likesOranges: String) {

    override fun toString() = "$name - $likesOranges"

}