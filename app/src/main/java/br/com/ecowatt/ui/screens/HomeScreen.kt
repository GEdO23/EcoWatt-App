package br.com.ecowatt.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ecowatt.R

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToEnergyConsumption: () -> Unit
) {
    Box(modifier = modifier) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_ecowatt),
                    contentDescription = "",
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            color = Color(0xFF007FFF),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp)
                )
            }
            Button(
                onClick = navigateToEnergyConsumption,
                colors = ButtonColors(
                    containerColor = Color(0xFF007FFF),
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.DarkGray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = "Energy Consumption")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier
            .fillMaxSize(),
        navigateToEnergyConsumption = {}
    )
}