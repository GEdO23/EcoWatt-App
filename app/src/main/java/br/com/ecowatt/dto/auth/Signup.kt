package br.com.ecowatt.dto.auth

import br.com.ecowatt.models.user.User

/**
 * Data class representing a sign-up request.
 *
 * @property displayName The display name of the user.
 * @property email The email of the user.
 * @property password The password of the user.
 * @property returnSecureToken Whether or not to return an ID and refresh token. Should always be true.
 * @see SignupResponse
 */
data class SignupRequest(
    val displayName: String,
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)

/**
 * Data class representing a sign-up response.
 *
 * @property displayName The display name of the user.
 * @property email The email of the user.
 * @see SignupRequest
 */
data class SignupResponse(
    val displayName: String,
    val email: String
) {
    /**
     * Converts the sign-up response to a User object.
     *
     * @return A [User] object with the display name and email from the sign-up response.
     * @see User
     */
    fun toUser(): User {
        return User(
            displayName = displayName,
            email = email
        )
    }
}