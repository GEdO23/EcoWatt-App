package br.com.ecowatt.ui.screens.devices

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.ecowatt.R
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.DeviceSampleData
import br.com.ecowatt.models.device.emptyDevice
import br.com.ecowatt.ui.components.device.DeviceForm
import br.com.ecowatt.ui.theme.Azure500
import br.com.ecowatt.ui.theme.EcoWattTheme
import br.com.ecowatt.ui.theme.Neutral1000

@Composable
fun FormDeviceScreen(
    modifier: Modifier = Modifier,
    device: MutableState<Device> = remember { mutableStateOf(emptyDevice()) },
    onSave: (filledDevice: Device) -> Unit
) {
    Box(modifier = modifier) {
        DeviceForm(modifier = Modifier.padding(16.dp))
        
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            onClick = { onSave(device.value) },
            containerColor = Azure500,
            contentColor = Neutral1000
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_save),
                contentDescription = ""
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun FormDeviceScreenPreview() {
    EcoWattTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            FormDeviceScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                device = remember { mutableStateOf(DeviceSampleData.lowConsumptionLevelDevice) },
                onSave = {}
            )
        }
    }
}