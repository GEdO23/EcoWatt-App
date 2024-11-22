package br.com.ecowatt.ui.components

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * @property size the size of the icon.
 */
enum class IconSize(
    val size: Dp
) {
    /**
     * Extra large icon size.
     *
     * @property size 96.dp
     * */
    XL(size = 96.dp),

    /**
     * Large icon size.
     *
     * @property size 64.dp
     * */
    LG(size = 64.dp),

    /**
     * Medium icon size.
     *
     * @property size 32.dp
     * */
    MD(size = 32.dp),

    /**
     * Small icon size.
     *
     * @property size 16.dp
     * */
    SM(size = 16.dp)
}