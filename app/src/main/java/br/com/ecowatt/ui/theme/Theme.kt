package br.com.ecowatt.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Azure400,
    onPrimary = Gray800,

    primaryContainer = Azure400,
    onPrimaryContainer = Gray800,

    secondaryContainer = Gray800,
    onSecondaryContainer = Azure400,

    tertiaryContainer = Red900,
    onTertiaryContainer = Red600,

    surface = Gray800,
    onSurface = Gray200,
    onSurfaceVariant = Gray400,
    background = Gray800,
    onBackground = Gray200,

    outlineVariant = Azure400
)

private val LightColorScheme = lightColorScheme(
    primary = Azure500,
    onPrimary = Neutral1000,

    primaryContainer = Azure500,
    onPrimaryContainer = Neutral1000,

    secondaryContainer = Neutral1000,
    onSecondaryContainer = Azure500,

    tertiaryContainer = Red100,
    onTertiaryContainer = Red400,

    surface = Neutral1000,
    onSurface = Gray800,
    onSurfaceVariant = Gray600,
    background = Neutral1000,
    onBackground = Gray800,

    outlineVariant = Azure500
)

@Composable
fun EcoWattTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}