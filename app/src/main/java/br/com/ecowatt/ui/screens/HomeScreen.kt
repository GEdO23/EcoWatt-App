package br.com.ecowatt.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ecowatt.R
import br.com.ecowatt.models.User
import br.com.ecowatt.ui.components.Button
import br.com.ecowatt.ui.theme.Gray600
import br.com.ecowatt.ui.theme.Gray800

@Composable
fun HomeScreen(
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

        Button(
            modifier = Modifier.fillMaxWidth(),
            text = "Energy Consumption",
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
            text = "Hi, $userName",
            color = Gray800,
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = "Welcome back!",
            color = Gray600,
            fontSize = 24.sp
        )
    }
}

@Composable
private fun AppIcon(size: Dp = 32.dp) {
    Image(
        painter = painterResource(R.drawable.ic_ecowatt),
        contentDescription = "",
        modifier = Modifier
            .size(size)
            .background(
                color = Color(0xFF007FFF),
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
        user = br.com.ecowatt.sampledata.UserSampleData.gabriel,
        onEnergyConsumptionClick = {}
    )
}