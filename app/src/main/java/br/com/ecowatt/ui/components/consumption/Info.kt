package br.com.ecowatt.ui.components.consumption

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ecowatt.models.Device
import br.com.ecowatt.sampledata.lowConsumptionLevelDeviceSampleData
import br.com.ecowatt.ui.components.device.DeviceInfoContainer
import br.com.ecowatt.ui.theme.Azure500

@Composable
fun EnergyConsumptionInfo(
    modifier: Modifier = Modifier,
    device: Device
) {
    DeviceInfoContainer(
        modifier = modifier,
        symbol = IconType.CONSUMPTION_LEVEL
    ) {
        Text(
            text = "${device.getCurrentConsumptionLevel()} watts/minute",
            color = Azure500,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.5.sp
        )
    }
}

@Composable
fun ConsumptionReportsInfo(
    modifier: Modifier = Modifier,
    device: Device,
    onClick: () -> Unit
) {
    DeviceInfoContainer(
        modifier = modifier,
        symbol = IconType.CONSUMPTION_REPORT,
        onClick = onClick
    ) {
        Text(
            text = "${device.getNumberOfReports()} consumption reports",
            color = Azure500,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.5.sp
        )
    }
}

@Composable
fun ConsumptionLimitInfo(
    modifier: Modifier = Modifier,
    device: Device
) {
    DeviceInfoContainer(
        modifier = modifier,
        symbol = IconType.CONSUMPTION_LEVEL
    ) {
        Text(
            text = "Consumption limit: ${device.consumptionLimit} watts",
            color = Azure500,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.5.sp
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun InfoListPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        EnergyConsumptionInfo(
            modifier = Modifier.fillMaxWidth(),
            device = lowConsumptionLevelDeviceSampleData
        )

        ConsumptionLimitInfo(
            modifier = Modifier.fillMaxWidth(),
            device = lowConsumptionLevelDeviceSampleData
        )

        ConsumptionReportsInfo(
            modifier = Modifier.fillMaxWidth(),
            device = lowConsumptionLevelDeviceSampleData,
            onClick = {}
        )
    }
}