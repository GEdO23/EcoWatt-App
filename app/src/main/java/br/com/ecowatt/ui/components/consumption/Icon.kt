package br.com.ecowatt.ui.components.consumption

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
import br.com.ecowatt.ui.theme.Azure500
import br.com.ecowatt.ui.theme.Neutral1000
import br.com.ecowatt.ui.theme.Red400

private fun getBackgroundColor(
    isConsumptionHigh: Boolean
): Color {
    return if (isConsumptionHigh) Red400 else Azure500
}

@Composable
fun ConsumptionLevelIcon(
    size: IconSize = IconSize.MD,
    isConsumptionHigh: Boolean = false
) {
    Box(
        modifier = Modifier
            .size(size.boxSize)
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

@Composable
fun ConsumptionReportIcon(
    size: IconSize = IconSize.MD,
    isConsumptionHigh: Boolean = false
) {
    Box(
        modifier = Modifier
            .size(size.boxSize)
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