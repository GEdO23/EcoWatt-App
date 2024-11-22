package br.com.ecowatt.dto.auth

import br.com.ecowatt.models.User

data class SignupRequest(
    val displayName: String,
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)

data class SignupResponse(
    val displayName: String,
    val email: String
) {
    fun toUser(): User {
        return User(
            displayName = displayName,
            email = email
        )
    }
}
