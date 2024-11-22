package br.com.ecowatt.ui.screens.devices

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ecowatt.R
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.DeviceSampleData
import br.com.ecowatt.ui.components.device.ConsumptionLimitInfo
import br.com.ecowatt.ui.components.device.ConsumptionReportsInfo
import br.com.ecowatt.ui.components.device.EnergyConsumptionInfo

@Composable
internal fun DeviceDetailsScreen(
    modifier: Modifier = Modifier,
    device: Device,
    onClickEditDevice: () -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
                    .background(
                        color = Color.Unspecified,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.outline,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
            ) {
                Text(
                    text = device.location,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 0.5.sp,
                    lineHeight = 32.sp * 0.8
                )

                Text(
                    text = device.name,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.5.sp,
                    lineHeight = 32.sp * 1.5
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                EnergyConsumptionInfo(
                    modifier = Modifier.fillMaxWidth(),
                    device = device
                )

                ConsumptionLimitInfo(
                    modifier = Modifier.fillMaxWidth(),
                    device = device
                )

                ConsumptionReportsInfo(
                    modifier = Modifier.fillMaxWidth(),
                    device = device,
                    onClick = {}
                )
            }
        }

        FloatingActionButton(
            onClick = onClickEditDevice,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_edit),
                contentDescription = stringResource(R.string.ic_description_edit_device)
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DeviceDetailsScreenPreview() {
    DeviceDetailsScreen(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        device = DeviceSampleData.lowConsumptionLevelDevice,
        onClickEditDevice = {}
    )
}