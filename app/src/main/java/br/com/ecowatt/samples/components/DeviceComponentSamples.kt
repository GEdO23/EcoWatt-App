package br.com.ecowatt.samples.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import br.com.ecowatt.models.Device
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
}