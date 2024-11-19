package br.com.ecowatt.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ecowatt.R
import br.com.ecowatt.navigation.Screen
import br.com.ecowatt.ui.theme.EcoWattTheme
import br.com.ecowatt.ui.theme.Gray800

/**
 * Component that displays the top bar of the EcoWatt app.
 *
 * @param modifier The [Modifier] for this composable.
 * @param navigateUp Handles the back navigation action.
 * @param canNavigateBack Indicates if the back navigation is enabled.
 * @param currentScreen The current [Screen].
 */
@Composable
fun EcoWattTopBar(
    modifier: Modifier = Modifier,
    canNavigateBack: Boolean = false,
    navigateUp: () -> Unit = {},
    currentScreen: Screen
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (canNavigateBack) {
            IconButton(
                onClick = navigateUp,
                colors = IconButtonDefaults.iconButtonColors()
                    .copy(contentColor = Gray800)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_right),
                    contentDescription = "Go back"
                )
            }
        }
        Text(
            text = currentScreen.title,
            color = Gray800,
            fontSize = 48.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.5.sp,
            lineHeight = 48.sp * 1.2
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun EcoWattTopBarPreview() {
    EcoWattTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 16.dp),
            topBar = {
                EcoWattTopBar(
                    canNavigateBack = true,
                    navigateUp = {},
                    currentScreen = Screen.ENERGY_CONSUMPTION
                )
            }
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {}
        }
    }
}