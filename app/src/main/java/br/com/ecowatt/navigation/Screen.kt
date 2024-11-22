package br.com.ecowatt.navigation

/**
 * Enum class representing the different screens in the EcoWatt app.
 *
 * Screens:
 * * [WELCOME]
 * * [SIGNUP]
 * * [LOGIN]
 * * [HOME]
 * * [ENERGY_CONSUMPTION]
 * * [REGISTER_DEVICE]
 * * [DEVICE_DETAILS]
 * * [UPDATE_DEVICE]
 *
 * @property title The title of the screen.
 */
enum class Screen(
    val title: String? = null,
) {
    /**
     * Welcome screen.
     */
    WELCOME,

    /**
     * Sign-up screen.
     */
    SIGNUP("Sign up"),

    /**
     * Login screen.
     */
    LOGIN("Login"),

    /**
     * Home screen.
     * */
    HOME("Home"),

    /**
     * Energy consumption screen.
     * */
    ENERGY_CONSUMPTION,

    /**
     * Screen for registering a new device.
     * */
    REGISTER_DEVICE("Register device"),

    /**
     * Screen for displaying device details.
     */
    DEVICE_DETAILS,

    /**
     * Screen for updating an device.
     */
    UPDATE_DEVICE("Update device")
}
