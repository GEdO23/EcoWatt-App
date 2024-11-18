package br.com.ecowatt.ui.components

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times

enum class IconSize(
    val boxSize: Dp,
    val iconSize: Dp
) {
    XL(boxSize = 96.dp, iconSize = calculateIconSize(96.dp)),
    LG(boxSize = 64.dp, iconSize = calculateIconSize(64.dp)),
    MD(boxSize = 32.dp, iconSize = calculateIconSize(32.dp)),
    SM(boxSize = 16.dp, iconSize = calculateIconSize(16.dp))
}

private fun calculateIconSize(
    boxSize: Dp
): Dp {
    val iconSizePercentage = 0.4
    return iconSizePercentage * boxSize
}