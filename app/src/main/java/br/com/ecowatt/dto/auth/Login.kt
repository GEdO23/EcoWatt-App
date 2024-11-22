package br.com.ecowatt.dto.auth

import br.com.ecowatt.models.User

/**
 * Data class representing a login request.
 *
 * @property email The email of the user.
 * @property password The password of the user.
 * @property returnSecureToken Whether or not to return an ID and refresh token. Should always be true.
 * @see LoginResponse
 */
data class LoginRequest(
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)

/**
 * Data class representing a login response.
 *
 * @property displayName The display name of the user.
 * @property email The email of the user.
 * @see LoginRequest
 */
data class LoginResponse(
    val displayName: String,
    val email: String
) {
    /**
     * Converts the login response to a User object.
     *
     * @return A [User] object with the display name and email from the login response.
     * @see User
     */
    fun toUser(): User {
        return User(
            displayName = displayName,
            email = email
        )
    }
}