package br.com.ecowatt.ui.components.device.list

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.ecowatt.R
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.DeviceSampleData
import br.com.ecowatt.ui.components.device.ConsumptionLevelIcon

/**
 * Component to display an energy consumption list item.
 *
 * @param device the device whose energy consumption is being displayed.
 * @param isConsumptionHigh indicates if the device's energy consumption is high.
 * @param onClick called when this list item is clicked.
 * @param onDeleteDevice called when the delete button of this list item is clicked.
 * @see Device
 * @see EnergyConsumptionList
 */
@Composable
internal fun EnergyConsumptionListItem(
    device: Device,
    isConsumptionHigh: Boolean,
    onClick: (deviceClicked: Device) -> Unit,
    onDeleteDevice: () -> Unit
) {
    ListItem(
        modifier = Modifier.clickable { onClick(device) },
        leadingContent = {
            ConsumptionLevelIcon(isConsumptionHigh = isConsumptionHigh)
        },
        headlineContent = {
            Text(device.name)
        },
        supportingContent = {
            Text(
                stringResource(
                    R.string.energy_consumption_per_minute,
                    device.getCurrentConsumptionLevel(),
                    stringResource(R.string.energy_unit)
                )
            )
        },
        trailingContent = {
            IconButton(onClick = onDeleteDevice) {
                Icon(
                    painter = painterResource(R.drawable.ic_delete),
                    contentDescription = stringResource(R.string.ic_description_delete_device)
                )
            }
        }
    )
}

@Preview
@Composable
private fun LowEnergyConsumptionListItemPreview() {
    EnergyConsumptionListItem(
        device = DeviceSampleData.lowConsumptionLevelDevice,
        isConsumptionHigh = false,
        onClick = {},
        onDeleteDevice = {}
    )
}

@Preview
@Composable
private fun HighEnergyConsumptionListItemPreview() {
    EnergyConsumptionListItem(
        device = DeviceSampleData.highConsumptionLevelDevice,
        isConsumptionHigh = true,
        onClick = {},
        onDeleteDevice = {}
    )
}