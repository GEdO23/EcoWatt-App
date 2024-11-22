package br.com.ecowatt.ui.components.device

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.DeviceSampleData
import br.com.ecowatt.ui.components.device.list.EmptyDeviceListAlert
import br.com.ecowatt.ui.components.device.list.EnergyConsumptionList

internal object Samples {

    @JvmStatic
    @Composable
    internal fun ConsumptionLevelIconSample(
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

    @JvmStatic
    @Composable
    internal fun ConsumptionReportIconSample(
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


    @JvmStatic
    @Composable
    internal fun InfoListSample() {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .statusBarsPadding()
                .padding(16.dp)
        ) {
            EnergyConsumptionInfo(
                modifier = Modifier.fillMaxWidth(),
                device = DeviceSampleData.lowConsumptionLevelDevice
            )

            ConsumptionLimitInfo(
                modifier = Modifier.fillMaxWidth(),
                device = DeviceSampleData.lowConsumptionLevelDevice
            )

            ConsumptionReportsInfo(
                modifier = Modifier.fillMaxWidth(),
                device = DeviceSampleData.lowConsumptionLevelDevice,
                onClick = {}
            )
        }
    }

    @JvmStatic
    @Composable
    internal fun EmptyDeviceListAlertSample(
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