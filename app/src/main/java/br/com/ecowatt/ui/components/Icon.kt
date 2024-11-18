package br.com.ecowatt.ui.components

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times

private const val iconSizePercentage = 0.4

/**
 * @property containerSize the size of the icon's container.
 * @property iconSize the size of the icon.
 */
enum class IconSize(
    val containerSize: Dp,
    val iconSize: Dp
) {
    /** 
     * Extra large icon size.
     * 
     * @property containerSize 96.dp
     * @property iconSize 38.4.dp (40% of container's size)
     * */
    XL(containerSize = 96.dp, iconSize = calculateIconSize(96.dp)),

    /**
     * Large icon size.
     *
     * @property containerSize 64.dp
     * @property iconSize 25.6.dp (40% of container's size)
     * */
    LG(containerSize = 64.dp, iconSize = calculateIconSize(64.dp)),

    /**
     * Medium icon size.
     *
     * @property containerSize 32.dp
     * @property iconSize 12.8.dp (40% of container's size)
     * */
    MD(containerSize = 32.dp, iconSize = calculateIconSize(32.dp)),

    /**
     * Small icon size.
     *
     * @property containerSize 16.dp
     * @property iconSize 6.4.dp (40% of container's size)
     * */
    SM(containerSize = 16.dp, iconSize = calculateIconSize(16.dp))
}

/**
 * Function that calculates the icon size based on the box size.
 *
 * @param boxSize the size of the box containing the icon.
 * @return [Dp] the calculated size of the icon.
 */
private fun calculateIconSize(
    boxSize: Dp
): Dp {
    return iconSizePercentage * boxSize
}