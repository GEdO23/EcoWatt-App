package br.com.ecowatt.ui.components.device.list

import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.ecowatt.R
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.DeviceSampleData
import br.com.ecowatt.ui.components.device.ConsumptionLevelIcon
import br.com.ecowatt.ui.theme.*

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
        colors = getListItemColors(isConsumptionHigh),
        leadingContent = {
            ConsumptionLevelIcon(isConsumptionHigh = isConsumptionHigh)
        },
        headlineContent = {
            Text(device.name)
        },
        supportingContent = {
            Text("${device.getCurrentConsumptionLevel()} watts/minute")
        },
        trailingContent = {
            IconButton(onClick = onDeleteDevice) {
                Icon(
                    painter = painterResource(R.drawable.ic_delete),
                    contentDescription = "Delete device"
                )
            }
        }
    )
}

/**
 * Function to get the colors for the list item based on consumption level.
 *
 * @param isConsumptionHigh indicates if the device's energy consumption is high.
 * @return [ListItemColors] the colors to be used for the list item.
 * @see Device
 * @see EnergyConsumptionListItem
 * @see ListItemColors
 */
private fun getListItemColors(
    isConsumptionHigh: Boolean
): ListItemColors {
    val listItemColorsLowConsumption = ListItemColors(
        containerColor = Neutral1000,
        headlineColor = Gray800,
        leadingIconColor = Gray600,
        overlineColor = Gray600,
        supportingTextColor = Gray600,
        trailingIconColor = Gray600,
        disabledHeadlineColor = Gray600,
        disabledLeadingIconColor = Gray400,
        disabledTrailingIconColor = Gray400
    )

    val listItemColorsHighConsumption = ListItemColors(
        containerColor = Red100,
        headlineColor = Red400,
        leadingIconColor = Red400,
        overlineColor = Red400,
        supportingTextColor = Red400,
        trailingIconColor = Red400,
        disabledHeadlineColor = Red400,
        disabledLeadingIconColor = Red400,
        disabledTrailingIconColor = Red400
    )

    return if (isConsumptionHigh) listItemColorsHighConsumption
    else listItemColorsLowConsumption
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