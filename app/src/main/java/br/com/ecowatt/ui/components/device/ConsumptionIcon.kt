package br.com.ecowatt.ui.components.device

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.ecowatt.R
import br.com.ecowatt.ui.components.IconSize
import br.com.ecowatt.ui.components.device.IconType.CONSUMPTION_LEVEL
import br.com.ecowatt.ui.theme.Azure500
import br.com.ecowatt.ui.theme.Neutral1000
import br.com.ecowatt.ui.theme.Red400

/**
 * Enum class representing the types of icons used in the consumption components.
 * 
 * @property CONSUMPTION_LEVEL
 * 
 * @sample br.com.ecowatt.ui.components.consumption.ConsumptionLimitInfo
 */
enum class IconType {
    /** Icon representing the consumption level */
    CONSUMPTION_LEVEL,

    /** Icon representing the consumption report */
    CONSUMPTION_REPORT
}

/**
 * Component that displays an icon representing the consumption level.
 *
 * @param size the size of the icon, default is medium.
 * @param isConsumptionHigh indicates if the consumption is high, default is false.
 * @see IconSize
 * @see ConsumptionReportIcon
 * @sample br.com.ecowatt.samples.components.DeviceComponentSamples.ConsumptionLevelIcon
 */
@Composable
fun ConsumptionLevelIcon(
    size: IconSize = IconSize.MD,
    isConsumptionHigh: Boolean = false
) {
    Box(
        modifier = Modifier
            .size(size.containerSize)
            .background(
                color = getBackgroundColor(isConsumptionHigh),
                shape = RoundedCornerShape(100)
            )
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_energy),
            contentDescription = "",
            tint = Neutral1000,
            modifier = Modifier
                .size(size.iconSize)
                .align(Alignment.Center)
        )
    }
}

/**
 * Component that displays an icon representing the consumption report.
 *
 * @param size the size of the icon, default is medium.
 * @param isConsumptionHigh indicates if the consumption is high, default is false.
 * @see IconSize
 * @see ConsumptionLevelIcon
 * @sample br.com.ecowatt.samples.components.DeviceComponentSamples.ConsumptionReportIcon
 */
@Composable
fun ConsumptionReportIcon(
    size: IconSize = IconSize.MD,
    isConsumptionHigh: Boolean = false
) {
    Box(
        modifier = Modifier
            .size(size.containerSize)
            .background(
                color = getBackgroundColor(isConsumptionHigh),
                shape = RoundedCornerShape(100)
            )
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_priority_high),
            contentDescription = "",
            tint = Neutral1000,
            modifier = Modifier
                .size(size.iconSize)
                .align(Alignment.Center)
        )
    }
}

/**
 * Function that gets the background color of the [ConsumptionLevelIcon].
 *
 * The background color is based on the consumption level.
 *
 * @param isConsumptionHigh indicates if the consumption is high.
 * @return [Color] of the background color to be used.
 */
private fun getBackgroundColor(
    isConsumptionHigh: Boolean
): Color {
    return if (isConsumptionHigh) Red400 else Azure500
}

@Preview
@Composable
private fun LowConsumptionLevelIconPreview() {
    ConsumptionLevelIcon(
        isConsumptionHigh = false
    )
}

@Preview
@Composable
private fun HighConsumptionLevelIconPreview() {
    ConsumptionLevelIcon(
        isConsumptionHigh = true
    )
}

@Preview
@Composable
private fun LowConsumptionReportIconPreview() {
    ConsumptionReportIcon(
        isConsumptionHigh = false
    )
}

@Preview
@Composable
private fun HighConsumptionReportIconPreview() {
    ConsumptionReportIcon(
        isConsumptionHigh = true
    )
}