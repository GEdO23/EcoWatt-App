package br.com.ecowatt.ui.components.device

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.math.BigDecimal

/**
 * A composable function that displays a form for entering device details.
 *
 * @param modifier A [Modifier] for customizing the layout or behavior of the form.
 */
@Composable
fun DeviceForm(modifier: Modifier = Modifier) {
    
    val name = remember { mutableStateOf("") }
    val type = remember { mutableStateOf("") }
    val location = remember { mutableStateOf("") }
    val consumptionLimit = remember { mutableStateOf(BigDecimal.ZERO) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            modifier = modifier,
            value = name.value,
            onValueChange = { name.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Name") }
        )

        OutlinedTextField(
            modifier = modifier,
            value = type.value,
            onValueChange = { type.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Type") }
        )

        OutlinedTextField(
            modifier = modifier,
            value = location.value,
            onValueChange = { location.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text("Location") }
        )

        OutlinedTextField(
            modifier = modifier,
            value = consumptionLimit.value.toPlainString(),
            onValueChange = { consumptionLimit.value = it.toBigDecimalOrNull() ?: BigDecimal.ZERO },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Maximum energy level") },
            suffix = { Text("watts") }
        )
    }
}

@Preview
@Composable
fun DeviceFormPreview() {
    DeviceForm()
}
