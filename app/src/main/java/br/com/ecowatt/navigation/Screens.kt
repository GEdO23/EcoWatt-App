package br.com.ecowatt.navigation

/**
 * Enum class representing the different screens in the EcoWatt app.
 *
 * Screens:
 * * [HOME]
 * * [ENERGY_CONSUMPTION]
 * * [NEW_DEVICE]
 *
 * @property title The title of the screen.
 */
enum class Screen(
    val title: String,
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
    ENERGY_CONSUMPTION("Energy consumption"),

    /**
     * Screen for registering a new device.
     *
     * @sample br.com.ecowatt.ui.screens.FormDeviceScreen
     * */
    NEW_DEVICE("Register device")
}
