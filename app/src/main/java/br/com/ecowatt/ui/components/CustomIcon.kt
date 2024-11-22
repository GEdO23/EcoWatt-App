package br.com.ecowatt.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.times

/**
 * A composable function that displays a custom icon with a specified size, color, and drawable resource.
 *
 * @param size The size of the icon, default is [IconSize.MD].
 * @param color The background color of the icon, default is [Color.Unspecified].
 * @param drawable The drawable resource ID for the icon.
 * @param description The content description for the icon, used for accessibility.
 * @sample br.com.ecowatt.ui.components.device.ConsumptionLevelIcon
 * @sample br.com.ecowatt.ui.components.device.ConsumptionReportIcon
 * @see Icon
 */
@Composable
fun CustomIcon(
    size: IconSize = IconSize.MD,
    containerColor: Color = Color.Unspecified,
    color: Color = MaterialTheme.colorScheme.onSurface,
    @DrawableRes drawable: Int,
    description: String
) {
    val iconSizePercentage = 0.4

    Box(
        modifier = Modifier
            .size(size.size)
            .background(color = containerColor, shape = RoundedCornerShape(100))
    ) {
        Icon(
            painter = painterResource(drawable),
            contentDescription = description,
            tint = color,
            modifier = Modifier
                .size(iconSizePercentage * size.size)
                .align(Alignment.Center)
        )
    }
}