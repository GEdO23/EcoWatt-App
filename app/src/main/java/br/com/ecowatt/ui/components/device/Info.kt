package br.com.ecowatt.ui.components.device

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ecowatt.R
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.DeviceSampleData

/**
 * A composable function that displays the energy consumption information of a device.
 *
 * @param modifier A [Modifier] for customizing the layout or behavior of the component.
 * @param device The [Device] object containing the device information.
 * @sample br.com.ecowatt.ui.components.device.Samples.InfoListSample
 */
@Composable
internal fun EnergyConsumptionInfo(
    modifier: Modifier = Modifier,
    device: Device
) {
    val contentColor =
        if (device.isConsumptionLevelHigh()) MaterialTheme.colorScheme.onTertiaryContainer
        else MaterialTheme.colorScheme.onSecondaryContainer
    val shape = RoundedCornerShape(24.dp)

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(color = Color.Unspecified, shape = shape)
            .border(width = 2.dp, color = contentColor, shape = shape)
            .padding(16.dp)
    ) {
        ConsumptionLevelIcon(isConsumptionHigh = device.isConsumptionLevelHigh())

        Text(
            text = stringResource(
                R.string.energy_consumption_per_minute,
                device.getCurrentConsumptionLevel(),
                stringResource(R.string.energy_unit)
            ),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.5.sp
        )
    }
}

/**
 * A composable function that displays the consumption reports information of a device.
 *
 * @param modifier A [Modifier] for customizing the layout or behavior of the component.
 * @param device The [Device] object containing the device information.
 * @param onClick The callback to be invoked when the component is clicked.
 * @sample br.com.ecowatt.ui.components.device.Samples.InfoListSample
 */
@Composable
internal fun ConsumptionReportsInfo(
    modifier: Modifier = Modifier,
    device: Device,
    onClick: () -> Unit
) {
    val contentColor =
        if (device.hasUnresolvedAlerts()) MaterialTheme.colorScheme.onTertiaryContainer
        else MaterialTheme.colorScheme.onSecondaryContainer
    val shape = RoundedCornerShape(24.dp)

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(color =  Color.Unspecified, shape = shape)
            .border(width = 2.dp, color = contentColor, shape = shape)
            .padding(16.dp)
            .clickable { onClick() }
    ) {
        ConsumptionReportIcon(hasUnresolvedAlerts = device.hasUnresolvedAlerts())

        Text(
            text = stringResource(
                R.string.device_info_consumption_reports_text,
                device.getNumberOfReports()
            ),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.5.sp
        )
    }
}

/**
 * A composable function that displays the consumption limit information of a device.
 *
 * @param modifier A [Modifier] for customizing the layout or behavior of the component.
 * @param device The [Device] object containing the device information.
 * @sample br.com.ecowatt.ui.components.device.Samples.InfoListSample
 */
@Composable
internal fun ConsumptionLimitInfo(
    modifier: Modifier = Modifier,
    device: Device
) {
    val contentColor =
        if (device.isConsumptionLevelHigh()) MaterialTheme.colorScheme.onTertiaryContainer
        else MaterialTheme.colorScheme.onSecondaryContainer

    val shape = RoundedCornerShape(24.dp)

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(color =  Color.Unspecified, shape = shape)
            .border(width = 2.dp, color = contentColor, shape = shape)
            .padding(16.dp)
    ) {
        ConsumptionLevelIcon(isConsumptionHigh = device.isConsumptionLevelHigh())

        Text(
            text = stringResource(
                R.string.consumption_limit,
                device.consumptionLimit,
                stringResource(R.string.energy_unit)
            ),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.5.sp
        )
    }
}

@Preview
@Composable
private fun EnergyConsumptionInfoPreview() {
    EnergyConsumptionInfo(
        modifier = Modifier.fillMaxWidth(),
        device = DeviceSampleData.lowConsumptionLevelDevice
    )
}

@Preview
@Composable
private fun ConsumptionLimitInfoPreview() {
    ConsumptionLimitInfo(
        modifier = Modifier.fillMaxWidth(),
        device = DeviceSampleData.lowConsumptionLevelDevice
    )
}

@Preview
@Composable
private fun ConsumptionReportsInfoPreview() {
    ConsumptionReportsInfo(
        modifier = Modifier.fillMaxWidth(),
        device = DeviceSampleData.lowConsumptionLevelDevice,
        onClick = {}
    )
}