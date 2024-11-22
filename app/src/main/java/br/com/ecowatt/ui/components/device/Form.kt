package br.com.ecowatt.ui.components.device

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ecowatt.R
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.emptyDevice
import java.math.BigDecimal

/**
 * A composable function that displays a form for entering device details.
 *
 * @param modifier A [Modifier] for customizing the layout or behavior of the form.
 */
@Composable
fun DeviceForm(
    modifier: Modifier = Modifier,
    device: MutableState<Device> = mutableStateOf(emptyDevice())
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = device.value.name,
            onValueChange = { device.value = device.value.copy(name = it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(stringResource(R.string.form_label_device_name)) }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = device.value.type,
            onValueChange = { device.value = device.value.copy(type = it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(stringResource(R.string.form_label_device_type)) }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = device.value.location,
            onValueChange = { device.value = device.value.copy(location = it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(stringResource(R.string.form_label_device_location)) }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = device.value.consumptionLimit.toPlainString(),
            onValueChange = {
                val consumptionLimit = it.toBigDecimalOrNull() ?: BigDecimal.ZERO
                device.value = device.value.copy(consumptionLimit = consumptionLimit)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(stringResource(R.string.form_label_device_consumption_limit)) },
            suffix = { Text(stringResource(R.string.energy_unit)) }
        )
    }
}

@Preview
@Composable
private fun DeviceFormPreview() {
    DeviceForm()
}