package br.com.ecowatt.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ecowatt.R
import br.com.ecowatt.models.user.User
import br.com.ecowatt.models.user.UserSampleData
import br.com.ecowatt.ui.components.CustomButton

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    user: User,
    onEnergyConsumptionClick: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AppIcon(size = 48.dp)

        WelcomeUser(userName = user.displayName)

        CustomButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.btn_device_list_text),
            onClick = onEnergyConsumptionClick
        )
    }
}

@Composable
private fun WelcomeUser(userName: String) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.greetings, userName),
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = stringResource(R.string.welcome_back),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 24.sp
        )
    }
}

@Composable
private fun AppIcon(size: Dp = 32.dp) {
    Image(
        painter = painterResource(R.drawable.ic_ecowatt),
        contentDescription = stringResource(R.string.ic_description_app_icon),
        modifier = Modifier
            .size(size)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(size / 6)
            )
            .padding(size / 6)
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        user = UserSampleData.gabriel,
        onEnergyConsumptionClick = {}
    )
}