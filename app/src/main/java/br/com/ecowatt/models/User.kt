package br.com.ecowatt.models

data class User(
    val name: String,
    val email: String,
    val password: String
)

fun emptyUser(): User = User(name = "", email = "", password = "")
