package br.com.ecowatt.ui.navigation

import androidx.annotation.StringRes
import br.com.ecowatt.R
import br.com.ecowatt.ui.navigation.Screen.DEVICE_DETAILS
import br.com.ecowatt.ui.navigation.Screen.ENERGY_CONSUMPTION
import br.com.ecowatt.ui.navigation.Screen.HOME
import br.com.ecowatt.ui.navigation.Screen.LOGIN
import br.com.ecowatt.ui.navigation.Screen.REGISTER_DEVICE
import br.com.ecowatt.ui.navigation.Screen.SIGNUP
import br.com.ecowatt.ui.navigation.Screen.UPDATE_DEVICE
import br.com.ecowatt.ui.navigation.Screen.WELCOME

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
    @StringRes val title: Int? = null
) {
    /**
     * On boarding [NavGraph][androidx.navigation.NavGraph].
     */
    ON_BOARDING,
    
    /**
     * Welcome screen.
     */
    WELCOME,

    /**
     * Sign-up screen.
     */
    SIGNUP(R.string.screen_title_signup),

    /**
     * Login screen.
     */
    LOGIN(R.string.screen_title_login),

    /**
     * Home screen.
     * */
    HOME(R.string.screen_title_home),
    
    /**
     * Devices CRUD [NavGraph][androidx.navigation.NavGraph].
     */
    DEVICES,

    /**
     * Energy consumption screen.
     * */
    ENERGY_CONSUMPTION,

    /**
     * Screen for registering a new device.
     * */
    REGISTER_DEVICE(R.string.screen_title_register_device),

    /**
     * Screen for displaying device details.
     */
    DEVICE_DETAILS,

    /**
     * Screen for updating an device.
     */
    UPDATE_DEVICE(R.string.screen_title_update_device)
}
