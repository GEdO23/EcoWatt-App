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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ecowatt.R
import br.com.ecowatt.models.Device
import br.com.ecowatt.models.emptyDevice
import br.com.ecowatt.ui.theme.Azure500
import br.com.ecowatt.ui.theme.Neutral1000
import java.math.BigDecimal

/**
 * Component that displays a form for editing a Device.
 *
 * @param modifier Modifier to be applied to the form.
 * @param device MutableState of the Device being edited.
 */
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

/**
 * Component that displays a save button.
 *
 * @param modifier Modifier to be applied to the Floating Action Button.
 * @param onClick Function called when the button is clicked.
 * @param deviceToSave The Device to be saved.
 * @sample [br.com.ecowatt.ui.screens.FormDeviceScreen]
 */
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

/**
 * Component that displays an input field for the device name.
 *
 * @param modifier Modifier to be applied to the input field.
 * @param device MutableState of the Device being edited.
 * @see Device
 * @see DeviceForm
 * @sample br.com.ecowatt.ui.components.DeviceForm
 */
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

/**
 * Component that displays an input field for the device type.
 *
 * @param modifier Modifier to be applied to the input field.
 * @param device MutableState of the Device being edited.
 * @see Device
 * @see DeviceForm
 * @sample br.com.ecowatt.ui.components.DeviceForm
 */
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

/**
 * Component that displays an input field for the device location.
 *
 * @param modifier Modifier to be applied to the input field.
 * @param device MutableState of the Device being edited.
 * @see Device
 * @see DeviceForm
 * @sample br.com.ecowatt.ui.components.DeviceForm
 */
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

/**
 * Component that displays an input field for the device consumption limit.
 *
 * @param modifier Modifier to be applied to the input field.
 * @param device MutableState of the Device being edited.
 * @see Device
 * @see DeviceForm
 * @sample br.com.ecowatt.ui.components.DeviceForm
 */
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

@Preview
@Composable
fun DeviceFormPreview() {
    DeviceForm(
        device = remember { mutableStateOf(emptyDevice()) }
    )
}

@Preview
@Composable
fun SaveButtonPreview() {
    SaveButton(
        onClick = {},
        deviceToSave = emptyDevice()
    )
}

@Preview
@Composable
private fun NameFieldPreview() {
    NameField(
        device = remember { mutableStateOf(emptyDevice()) }
    )
}

@Preview
@Composable
private fun TypeFieldPreview() {
    TypeField(
        device = remember { mutableStateOf(emptyDevice()) }
    )
}

@Preview
@Composable
private fun LocationFieldPreview() {
    LocationField(
        device = remember { mutableStateOf(emptyDevice()) }
    )
}

@Preview
@Composable
private fun ConsumptionLimitFieldPreview() {
    ConsumptionLimitField(
        device = remember { mutableStateOf(emptyDevice()) }
    )
}
