package br.com.ecowatt.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ecowatt.R
import br.com.ecowatt.models.Device
import br.com.ecowatt.sampledata.highConsumptionLevelDeviceSampleData
import br.com.ecowatt.ui.components.consumption.EnergyConsumptionList
import br.com.ecowatt.ui.theme.Azure500
import br.com.ecowatt.ui.theme.EcoWattTheme
import br.com.ecowatt.ui.theme.Neutral1000

@Composable
fun EnergyConsumptionScreen(
    modifier: Modifier = Modifier,
    devices: List<Device>,
    onCreateDevice: () -> Unit,
    onDeleteDevice: (deviceId: String) -> Unit
) {
    Box(modifier = modifier) {
        EnergyConsumptionList(
            devices = devices,
            onClick = {},
            onDeleteDevice = onDeleteDevice
        )
        FloatingActionButton(
            onClick = onCreateDevice,
            containerColor = Azure500,
            contentColor = Neutral1000,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_add),
                contentDescription = ""
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun EnergyConsumptionScreenPreview() {
    EcoWattTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                EnergyConsumptionScreen(
                    modifier = Modifier.fillMaxSize(),
                    devices = listOf(
                        highConsumptionLevelDeviceSampleData,
                        highConsumptionLevelDeviceSampleData,
                        highConsumptionLevelDeviceSampleData
                    ),
                    onCreateDevice = {},
                    onDeleteDevice = {}
                )
            }
        }
    }
}