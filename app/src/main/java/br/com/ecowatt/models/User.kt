package br.com.ecowatt.models

data class User(
    val name: String,
    val email: String,
    val password: String
) {
    fun toRequest(): UserRequest {
        return UserRequest(
            displayName = name,
            email = email,
            password = password
        )
    }
}

data class UserRequest(
    val displayName: String,
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)

fun emptyUser(): User = User(name = "", email = "", password = "")
