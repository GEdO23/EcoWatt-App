package br.com.ecowatt.samples.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import br.com.ecowatt.models.Device
import br.com.ecowatt.ui.components.consumption.ConsumptionLevelIcon
import br.com.ecowatt.ui.components.consumption.ConsumptionReportIcon
import br.com.ecowatt.ui.components.consumption.EmptyDeviceListAlert
import br.com.ecowatt.ui.components.consumption.EnergyConsumptionList

/**
 * Object containing sample composable functions for device components.
 */
object DeviceComponentSamples {
    /**
     * Composable function that displays an alert if the device list is empty,
     * otherwise displays the energy consumption list.
     *
     * @param modifier The modifier to be applied to the Box.
     * @param devices List of [Device] objects to be displayed.
     */
    @JvmStatic
    @Composable
    fun EmptyDeviceListAlert(
        modifier: Modifier = Modifier,
        devices: List<Device>
    ) {
        Box(modifier = modifier) {
            if (devices.isEmpty()) {
                EmptyDeviceListAlert(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 64.dp)
                        .alpha(0.8F)
                )
            } else {
                EnergyConsumptionList(
                    devices = devices,
                    onClick = {},
                    onDeleteDevice = {}
                )
            }
        }
    }

    /**
     * Composable function that displays the consumption level icon 
     * and the current consumption level of the device.
     *
     * @param modifier The modifier to be applied to the Row.
     * @param device The [Device] object whose consumption level is to be displayed.
     */
    @JvmStatic
    @Composable
    fun ConsumptionLevelIcon(
        modifier: Modifier = Modifier,
        device: Device
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ConsumptionLevelIcon()
            Text("${device.getCurrentConsumptionLevel()} watts")
        }
    }

    /**
     * Composable function that displays the consumption report icon 
     * and the number of reports for the device.
     *
     * @param modifier The modifier to be applied to the Row.
     * @param device The [Device] object whose number of reports is to be displayed.
     */
    @JvmStatic
    @Composable
    fun ConsumptionReportIcon(
        modifier: Modifier = Modifier,
        device: Device
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ConsumptionReportIcon()
            Text("${device.getNumberOfReports()} reports")
        }
    }
}