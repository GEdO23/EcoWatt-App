package br.com.ecowatt.ui.components.consumption

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.ecowatt.R
import br.com.ecowatt.models.Device
import br.com.ecowatt.sampledata.highConsumptionLevelDeviceSampleData
import br.com.ecowatt.ui.theme.Gray400
import br.com.ecowatt.ui.theme.Gray600
import br.com.ecowatt.ui.theme.Gray800
import br.com.ecowatt.ui.theme.Neutral1000
import br.com.ecowatt.ui.theme.Red100
import br.com.ecowatt.ui.theme.Red400

@Composable
internal fun EnergyConsumptionListItem(
    device: Device,
    isConsumptionHigh: Boolean,
    onClick: () -> Unit,
    onDeleteDevice: () -> Unit
) {
    ListItem(
        modifier = Modifier.clickable { onClick() },
        colors = getListItemColors(isConsumptionHigh),
        leadingContent = {
            ConsumptionLevelIcon(isConsumptionHigh = isConsumptionHigh)
        },
        headlineContent = {
            Text(device.name)
        },
        supportingContent = {
            val currentConsumption =
                device.consumptions.firstOrNull()?.consumption ?: "0"
            Text("$currentConsumption watts/minute")
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
private fun ListItemLowLevelPreview() {
    EnergyConsumptionListItem(
        device = highConsumptionLevelDeviceSampleData,
        isConsumptionHigh = false,
        onClick = {},
        onDeleteDevice = {}
    )
}

@Preview
@Composable
private fun ListItemHighLevelPreview() {
    EnergyConsumptionListItem(
        device = highConsumptionLevelDeviceSampleData,
        isConsumptionHigh = true,
        onClick = {},
        onDeleteDevice = {}
    )
}