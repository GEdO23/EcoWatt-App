package br.com.ecowatt.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ecowatt.ui.components.Button
import br.com.ecowatt.ui.theme.Gray600
import br.com.ecowatt.ui.theme.Gray800

@Composable
internal fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onSignup: () -> Unit,
    onLogin: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(64.dp, Alignment.CenterVertically)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "EcoWatt",
                fontSize = 48.sp,
                fontWeight = FontWeight.SemiBold,
                color = Gray800
            )

            Text(
                text = "Your energy consumption monitoring app.",
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                color = Gray600
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                text = "Sign up",
                onClick = onSignup
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                text = "Login",
                onClick = onLogin
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp),
        onSignup = {},
        onLogin = {}
    )
}