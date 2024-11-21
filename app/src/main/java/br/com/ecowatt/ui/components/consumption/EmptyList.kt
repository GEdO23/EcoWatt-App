package br.com.ecowatt.ui.components.consumption

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ecowatt.R
import br.com.ecowatt.ui.theme.Gray800

/**
 * Composable function that displays an alert for an empty consumption list.
 *
 * @param modifier The modifier to be applied to this component
 * @sample br.com.ecowatt.samples.components.DeviceComponentSamples.EmptyDeviceListAlert
 */
@Composable
fun EmptyDeviceListAlert(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(R.drawable.img_empty_list),
            contentDescription = "",
            contentScale = ContentScale.Fit
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Empty list",
                textAlign = TextAlign.Center,
                color = Gray800,
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Get started by adding a \nnew device to the list",
                textAlign = TextAlign.Center,
                color = Gray800,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun EmptyListAlertPreview() {
    EmptyDeviceListAlert()
}