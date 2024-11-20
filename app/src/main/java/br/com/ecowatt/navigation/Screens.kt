package br.com.ecowatt.navigation

/**
 * Enum class representing the different screens in the EcoWatt app.
 *
 * Screens:
 * * [HOME]
 * * [ENERGY_CONSUMPTION]
 * * [REGISTER_DEVICE]
 *
 * @property title The title of the screen.
 */
enum class Screen(
    val title: String? = null,
) {
    /**
     * Home screen.
     *
     * @sample br.com.ecowatt.ui.screens.HomeScreen
     * */
    HOME("Home"),

    /**
     * Energy consumption screen.
     *
     * @sample br.com.ecowatt.ui.screens.EnergyConsumptionScreen
     * */
    ENERGY_CONSUMPTION,

    /**
     * Screen for registering a new device.
     *
     * @sample br.com.ecowatt.ui.screens.FormDeviceScreen
     * */
    REGISTER_DEVICE("Register device"),
    
    /**
     * Screen for displaying device details.
     * 
     * @sample br.com.ecowatt.ui.screens.DeviceDetailsScreen
     */
    DEVICE_DETAILS,
    
    /**
     * Screen for updating an device.
     *
     * @sample br.com.ecowatt.ui.screens.FormDeviceScreen
     */
    UPDATE_DEVICE("Update device")
}
