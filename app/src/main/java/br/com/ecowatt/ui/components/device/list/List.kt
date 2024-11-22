package br.com.ecowatt.ui.components.device.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.DeviceSampleData

/**
 * Component to display a list of devices and their energy consumption.
 *
 * @param modifier modifier to be applied to the LazyColumn.
 * @param devices list of devices to be displayed.
 * @param onClick called when an item is clicked.
 * @param onDeleteDevice called when the delete button of an item is clicked.
 */
@Composable
fun EnergyConsumptionList(
    modifier: Modifier = Modifier,
    devices: List<Device>,
    onClick: (deviceClicked: Device) -> Unit,
    onDeleteDevice: (deviceId: String) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(items = devices) { device ->
            EnergyConsumptionListItem(
                device = device,
                isConsumptionHigh = device.isConsumptionLevelHigh(),
                onClick = { onClick(it) },
                onDeleteDevice = { onDeleteDevice(device.id) }
            )
        }
    }
}

@Preview
@Composable
private fun EnergyConsumptionListPreview() {
    EnergyConsumptionList(
        devices = DeviceSampleData.listOfDeviceConsumptionLevels,
        onClick = {},
        onDeleteDevice = {}
    )
}