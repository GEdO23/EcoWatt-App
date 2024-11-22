package br.com.ecowatt.ui.components.device

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ecowatt.R
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.DeviceSampleData
import br.com.ecowatt.ui.theme.Azure500
import br.com.ecowatt.ui.theme.Neutral1000

/**
 * Component that displays the current energy consumption level of a device.
 *
 * @param modifier Modifier to be applied to the container.
 * @param device The device whose consumption level is to be displayed.
 */
@Composable
fun EnergyConsumptionInfo(
    modifier: Modifier = Modifier,
    device: Device
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(color = Neutral1000, shape = RoundedCornerShape(24.dp))
            .border(width = 2.dp, color = Azure500, shape = RoundedCornerShape(24.dp))
            .padding(16.dp)
    ) {
        ConsumptionLevelIcon()

        Text(
            text = "${device.getCurrentConsumptionLevel()} watts/minute",
            color = Azure500,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.5.sp
        )
    }
}

/**
 * Component that displays the number of consumption reports of a device
 *
 * @param modifier The modifier to be applied to the container.
 * @param device The device whose consumption reports are to be displayed.
 * @param onClick Function to be executed when the container is clicked.
 */
@Composable
fun ConsumptionReportsInfo(
    modifier: Modifier = Modifier,
    device: Device,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(color = Neutral1000, shape = RoundedCornerShape(24.dp))
            .border(width = 2.dp, color = Azure500, shape = RoundedCornerShape(24.dp))
            .padding(16.dp)
            .clickable { onClick() }
    ) {
        ConsumptionReportIcon()

        Text(
            text = "${device.getNumberOfReports()} consumption reports",
            color = Azure500,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.5.sp
        )

        Icon(
            painter = painterResource(R.drawable.ic_chevron_left),
            contentDescription = "",
            tint = Azure500
        )
    }
}

/**
 * Component that displays the consumption limit of a device.
 *
 * @param modifier The modifier to be applied to the container.
 * @param device The device whose consumption limit is to be displayed.
 */
@Composable
fun ConsumptionLimitInfo(
    modifier: Modifier = Modifier,
    device: Device
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(color = Neutral1000, shape = RoundedCornerShape(24.dp))
            .border(width = 2.dp, color = Azure500, shape = RoundedCornerShape(24.dp))
            .padding(16.dp)
    ) {
        ConsumptionLevelIcon()

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