package br.com.ecowatt

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.ecowatt.navigation.Screen
import br.com.ecowatt.ui.components.EcoWattTopBar
import br.com.ecowatt.ui.screens.DeviceDetailsScreen
import br.com.ecowatt.ui.screens.EnergyConsumptionScreen
import br.com.ecowatt.ui.screens.FormDeviceScreen
import br.com.ecowatt.ui.screens.HomeScreen
import br.com.ecowatt.ui.theme.EcoWattTheme
import br.com.ecowatt.ui.viewmodel.DeviceViewModel
import br.com.ecowatt.ui.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {

    private val deviceViewModel = viewModels<DeviceViewModel>()
    private val userViewModel = viewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcoWattTheme {
                EcoWattApp(
                    deviceViewModel = deviceViewModel.value,
                    userViewModel = userViewModel.value
                )
            }
        }
    }

    @Composable
    fun EcoWattApp(
        navController: NavHostController = rememberNavController(),
        deviceViewModel: DeviceViewModel,
        userViewModel: UserViewModel
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        val currentScreen =
            Screen.valueOf(backStackEntry.value?.destination?.route ?: Screen.HOME.name)

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            topBar = {
                EcoWattTopBar(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.HOME.name,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = Screen.HOME.name) {
                    HomeScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        user = userViewModel.user.value,
                        navigateToEnergyConsumption = { navController.navigate(Screen.ENERGY_CONSUMPTION.name) }
                    )
                }
                composable(route = Screen.ENERGY_CONSUMPTION.name) {
                    EnergyConsumptionScreen(
                        modifier = Modifier.fillMaxSize(),
                        devices = remember { deviceViewModel.devices },
                        onClickDevice = {
                            deviceViewModel.currentDevice.value = it
                            navController.navigate(Screen.DEVICE_DETAILS.name)
                        },
                        onDeleteDevice = { deviceId ->
                            deviceViewModel.deleteDevice(deviceId)
                            Toast.makeText(
                                this@MainActivity,
                                "Device deleted!",
                                Toast.LENGTH_LONG
                            ).show()
                        },
                        onCreateDevice = { navController.navigate(Screen.REGISTER_DEVICE.name) }
                    )
                }
                composable(route = Screen.REGISTER_DEVICE.name) {
                    FormDeviceScreen(
                        modifier = Modifier.fillMaxSize(),
                        onSave = { filledDevice ->
                            deviceViewModel.newDevice(filledDevice)
                            navController.popBackStack()
                            Toast.makeText(
                                this@MainActivity,
                                "Device saved!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    )
                }
                composable(route = Screen.DEVICE_DETAILS.name) {
                    DeviceDetailsScreen(
                        modifier = Modifier.fillMaxSize(),
                        device = deviceViewModel.currentDevice.value,
                        onClickEditDevice = { navController.navigate(Screen.UPDATE_DEVICE.name) }
                    )
                }
                composable(route = Screen.UPDATE_DEVICE.name) {
                    val currentDevice = deviceViewModel.currentDevice
                    FormDeviceScreen(
                        modifier = Modifier.fillMaxSize(),
                        device = currentDevice,
                        onSave = { filledDevice ->
                            deviceViewModel.updateDevice(
                                currentDevice.value.id,
                                filledDevice
                            )
                            navController.popBackStack()
                            Toast.makeText(
                                this@MainActivity,
                                "Device updated!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    )
                }
            }
        }
    }
}
