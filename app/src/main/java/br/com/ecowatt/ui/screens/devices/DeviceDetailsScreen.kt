package br.com.ecowatt.ui.screens.devices

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ecowatt.R
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.DeviceSampleData
import br.com.ecowatt.ui.components.device.ConsumptionLimitInfo
import br.com.ecowatt.ui.components.device.ConsumptionReportsInfo
import br.com.ecowatt.ui.components.device.DeviceHeader
import br.com.ecowatt.ui.components.device.EnergyConsumptionInfo
import br.com.ecowatt.ui.theme.Azure500
import br.com.ecowatt.ui.theme.Neutral1000

@Composable
fun DeviceDetailsScreen(
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
            DeviceHeader(
                modifier = Modifier.fillMaxWidth(),
                device = device
            )
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
            containerColor = Azure500,
            contentColor = Neutral1000,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_edit),
                contentDescription = ""
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