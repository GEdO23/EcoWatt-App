package br.com.ecowatt.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.ecowatt.models.Device
import br.com.ecowatt.models.emptyDevice
import br.com.ecowatt.sampledata.lowConsumptionLevelDeviceSampleData
import br.com.ecowatt.ui.components.DeviceForm
import br.com.ecowatt.ui.components.SaveButton
import br.com.ecowatt.ui.theme.EcoWattTheme

@Composable
fun FormDeviceScreen(
    modifier: Modifier = Modifier,
    device: MutableState<Device> = remember { mutableStateOf(emptyDevice()) },
    onSave: (filledDevice: Device) -> Unit
) {
    Box(modifier = modifier) {
        DeviceForm(
            modifier = Modifier.padding(16.dp),
            device = device
        )
        SaveButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            onClick = onSave,
            deviceToSave = device.value
        )
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
                device = remember { mutableStateOf(lowConsumptionLevelDeviceSampleData) },
                onSave = {}
            )
        }
    }
}