package br.com.ecowatt.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ecowatt.models.Device
import br.com.ecowatt.sampledata.deviceSampleData

@Composable
fun EnergyConsumptionScreen(
    modifier: Modifier = Modifier,
    devices: List<Device>
) {
    Box(modifier = modifier) {
        LazyColumn {
            items(items = devices) {
                ListItem(
                    headlineContent = { Text(it.name) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun EnergyConsumptionScreenPreview() {
    EnergyConsumptionScreen(
        devices = listOf(
            deviceSampleData,
            deviceSampleData,
            deviceSampleData
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
}