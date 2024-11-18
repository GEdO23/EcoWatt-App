package br.com.ecowatt.ui.components.consumption

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.ecowatt.models.Device
import br.com.ecowatt.sampledata.highConsumptionLevelDeviceSampleData

@Composable
fun EnergyConsumptionList(
    modifier: Modifier = Modifier,
    devices: List<Device>,
    onClick: () -> Unit,
    onDeleteDevice: (deviceId: String) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(items = devices) { device ->
            EnergyConsumptionListItem(
                device = device,
                isConsumptionHigh = device.isConsumptionLevelHigh(),
                onClick = onClick,
                onDeleteDevice = { onDeleteDevice(device.id) }
            )
        }
    }
}

@Preview
@Composable
private fun ListPreview() {
    EnergyConsumptionList(
        devices = listOf(
            highConsumptionLevelDeviceSampleData,
            highConsumptionLevelDeviceSampleData,
            highConsumptionLevelDeviceSampleData
        ),
        onClick = {},
        onDeleteDevice = {}
    )
}