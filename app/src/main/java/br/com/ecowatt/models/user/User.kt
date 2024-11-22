package br.com.ecowatt.models.user

/**
 * Data class representing a user.
 *
 * @property displayName The display name of the user.
 * @property email The email of the user.
 */
data class User(
    val displayName: String,
    val email: String
)
