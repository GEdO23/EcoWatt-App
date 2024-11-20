package br.com.ecowatt.ui.components.device

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ecowatt.models.Device
import br.com.ecowatt.sampledata.lowConsumptionLevelDeviceSampleData
import br.com.ecowatt.ui.theme.Gray500
import br.com.ecowatt.ui.theme.Gray600
import br.com.ecowatt.ui.theme.Gray800
import br.com.ecowatt.ui.theme.Neutral1000

@Composable
fun DeviceHeader(
    modifier: Modifier = Modifier,
    device: Device
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .background(
                color = Neutral1000,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                color = Gray600,
                shape = RoundedCornerShape(16.dp),
                width = 2.dp
            )
            .padding(16.dp)
    ) {
        Text(
            text = device.location,
            color = Gray500,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.5.sp
        )
        Text(
            text = device.name,
            color = Gray800,
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.5.sp
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DeviceHeaderPreview() {
    DeviceHeader(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(16.dp),
        device = lowConsumptionLevelDeviceSampleData
    )
}