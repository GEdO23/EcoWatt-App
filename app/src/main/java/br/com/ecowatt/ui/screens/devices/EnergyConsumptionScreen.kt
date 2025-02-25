package br.com.ecowatt.ui.screens.devices

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ecowatt.R
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.DeviceSampleData
import br.com.ecowatt.ui.components.device.list.EmptyDeviceListAlert
import br.com.ecowatt.ui.components.device.list.EnergyConsumptionList
import br.com.ecowatt.ui.theme.EcoWattTheme

@Composable
internal fun EnergyConsumptionScreen(
    modifier: Modifier = Modifier,
    devices: List<Device>,
    onClickDevice: (deviceClicked: Device) -> Unit,
    onCreateDevice: () -> Unit,
    onDeleteDevice: (deviceId: String) -> Unit
) {
    Box(modifier = modifier) {
        if (devices.isEmpty()) {
            EmptyDeviceListAlert(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 64.dp, horizontal = 32.dp)
                    .alpha(0.8F)
            )
        } else {
            EnergyConsumptionList(
                devices = devices,
                onClick = { onClickDevice(it) },
                onDeleteDevice = onDeleteDevice
            )
        }
        FloatingActionButton(
            onClick = onCreateDevice,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_add),
                contentDescription = stringResource(R.string.ic_description_add_device)
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
                    devices = remember { DeviceSampleData.listOfDeviceConsumptionLevels },
                    onClickDevice = {},
                    onCreateDevice = {},
                    onDeleteDevice = {}
                )
            }
        }
    }
}