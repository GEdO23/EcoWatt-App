package br.com.ecowatt.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.ecowatt.R
import br.com.ecowatt.models.Device
import br.com.ecowatt.ui.theme.Azure500
import br.com.ecowatt.ui.theme.Neutral1000
import java.math.BigDecimal

@Composable
fun DeviceForm(
    modifier: Modifier = Modifier,
    device: MutableState<Device>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        NameField(
            modifier = Modifier.fillMaxWidth(),
            device = device
        )
        TypeField(
            modifier = Modifier.fillMaxWidth(),
            device = device
        )
        LocationField(
            modifier = Modifier.fillMaxWidth(),
            device = device
        )
        ConsumptionLimitField(
            modifier = Modifier.fillMaxWidth(),
            device = device
        )
    }
}

@Composable
fun SaveButton(
    modifier: Modifier = Modifier,
    onClick: (filledDevice: Device) -> Unit,
    deviceToSave: Device
) {
    FloatingActionButton(
        modifier = modifier,
        onClick = { onClick(deviceToSave) },
        containerColor = Azure500,
        contentColor = Neutral1000
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_save),
            contentDescription = ""
        )
    }
}

@Composable
private fun NameField(
    modifier: Modifier = Modifier,
    device: MutableState<Device>
) {
    OutlinedTextField(
        modifier = modifier,
        label = { Text("Name") },
        value = device.value.name,
        onValueChange = { device.value = device.value.copy(name = it) }
    )
}

@Composable
private fun TypeField(
    modifier: Modifier = Modifier,
    device: MutableState<Device>
) {
    OutlinedTextField(
        modifier = modifier,
        label = { Text("Type") },
        value = device.value.type,
        onValueChange = { device.value = device.value.copy(type = it) }
    )
}

@Composable
private fun LocationField(
    modifier: Modifier = Modifier,
    device: MutableState<Device>
) {
    OutlinedTextField(
        modifier = modifier,
        label = { Text("Location") },
        value = device.value.location,
        onValueChange = { device.value = device.value.copy(location = it) }
    )
}

@Composable
private fun ConsumptionLimitField(
    modifier: Modifier = Modifier,
    device: MutableState<Device>
) {
    OutlinedTextField(
        modifier = modifier,
        label = { Text("Maximum energy level") },
        suffix = { Text("watts") },
        value = device.value.consumptionLimit.toPlainString(),
        onValueChange = {
            device.value = device.value.copy(
                consumptionLimit = it.toBigDecimalOrNull() ?: BigDecimal.ZERO
            )
        }
    )
}