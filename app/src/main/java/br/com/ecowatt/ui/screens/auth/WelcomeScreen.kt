package br.com.ecowatt.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ecowatt.R
import br.com.ecowatt.ui.components.CustomButton
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
                text = stringResource(R.string.app_name),
                fontSize = 48.sp,
                fontWeight = FontWeight.SemiBold,
                color = Gray800
            )

            Text(
                text = stringResource(R.string.app_description),
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                color = Gray600
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                text = stringResource(R.string.btn_signup_text),
                onClick = onSignup
            )

            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                text = stringResource(R.string.btn_login_text),
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