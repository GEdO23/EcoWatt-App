package br.com.ecowatt.ui.components

import androidx.annotation.DrawableRes
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
import androidx.compose.ui.unit.times
import br.com.ecowatt.ui.theme.Neutral1000

@Composable
fun CustomIcon(
    size: IconSize = IconSize.MD,
    color: Color = Color.Unspecified,
    @DrawableRes drawable: Int,
    description: String
) {
    val iconSizePercentage = 0.4

    Box(
        modifier = Modifier
            .size(size.size)
            .background(color = color, shape = RoundedCornerShape(100))
    ) {
        Icon(
            painter = painterResource(drawable),
            contentDescription = description,
            tint = Neutral1000,
            modifier = Modifier
                .size(iconSizePercentage * size.size)
                .align(Alignment.Center)
        )
    }
}