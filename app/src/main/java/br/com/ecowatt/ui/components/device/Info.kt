package br.com.ecowatt.ui.components.device

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.ecowatt.R
import br.com.ecowatt.ui.components.consumption.ConsumptionLevelIcon
import br.com.ecowatt.ui.components.consumption.ConsumptionReportIcon
import br.com.ecowatt.ui.components.consumption.IconType
import br.com.ecowatt.ui.theme.Azure500
import br.com.ecowatt.ui.theme.Neutral1000

@Composable
fun DeviceInfoContainer(
    modifier: Modifier = Modifier,
    symbol: IconType,
    content: @Composable (RowScope.() -> Unit)
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(color = Neutral1000, shape = RoundedCornerShape(24.dp))
            .border(width = 2.dp, color = Azure500, shape = RoundedCornerShape(24.dp))
            .padding(16.dp)
    ) {
        DeviceInfoSymbol(symbol)
        content()
    }
}

@Composable
fun DeviceInfoContainer(
    modifier: Modifier = Modifier,
    symbol: IconType,
    onClick: () -> Unit,
    content: @Composable (RowScope.() -> Unit)
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(color = Neutral1000, shape = RoundedCornerShape(24.dp))
            .border(width = 2.dp, color = Azure500, shape = RoundedCornerShape(24.dp))
            .padding(16.dp)
            .clickable { onClick() }
    ) {
        DeviceInfoSymbol(symbol)
        content()
        Icon(
            painter = painterResource(R.drawable.ic_chevron_left),
            contentDescription = "",
            tint = Azure500
        )
    }
}

@Composable
private fun DeviceInfoSymbol(symbol: IconType) {
    return when (symbol) {
        IconType.CONSUMPTION_LEVEL -> {
            ConsumptionLevelIcon()
        }

        IconType.CONSUMPTION_REPORT -> {
            ConsumptionReportIcon()
        }
    }
}