package br.com.ecowatt

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.ecowatt.navigation.Routes
import br.com.ecowatt.ui.screens.EnergyConsumptionScreen
import br.com.ecowatt.ui.screens.FormDeviceScreen
import br.com.ecowatt.ui.theme.EcoWattTheme
import br.com.ecowatt.ui.viewmodel.DeviceViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = viewModels<DeviceViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcoWattApp()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun EcoWattApp(
        navController: NavHostController = rememberNavController()
    ) {
        EcoWattTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = Routes.ENERGY_CONSUMPTION.name,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable(route = Routes.ENERGY_CONSUMPTION.name) {
                        EnergyConsumptionScreen(
                            modifier = Modifier.fillMaxSize(),
                            devices = remember { viewModel.value.devices },
                            onDeleteDevice = { deviceId ->
                                viewModel.value.deleteDevice(deviceId)
                                Toast.makeText(
                                    this@MainActivity,
                                    "Device deleted!",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            onCreateDevice = { navController.navigate(Routes.NEW_DEVICE.name) }
                        )
                    }
                    composable(route = Routes.NEW_DEVICE.name) {
                        FormDeviceScreen(
                            modifier = Modifier.fillMaxSize(),
                            onSave = { filledDevice ->
                                viewModel.value.newDevice(filledDevice)
                                navController.popBackStack()
                                Toast.makeText(
                                    this@MainActivity,
                                    "Device saved!",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        )
                    }
                }
            }
        }
    }
}
