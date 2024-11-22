package br.com.ecowatt.ui.components.device

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.ecowatt.R
import br.com.ecowatt.ui.components.CustomIcon
import br.com.ecowatt.ui.components.IconSize

/**
 * Component that displays an icon representing the consumption level.
 *
 * @param iconSize the size of the icon, default is medium.
 * @param isConsumptionHigh indicates if the consumption is high, default is false.
 * @see IconSize
 * @see ConsumptionReportIcon
 * @sample br.com.ecowatt.ui.components.device.Samples.ConsumptionLevelIconSample
 */
@Composable
internal fun ConsumptionLevelIcon(
    iconSize: IconSize = IconSize.MD,
    isConsumptionHigh: Boolean
) {
    val containerColor =
        if (isConsumptionHigh) MaterialTheme.colorScheme.onTertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer
    
    CustomIcon(
        size = iconSize,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        containerColor = containerColor,
        drawable = R.drawable.ic_energy,
        description = stringResource(R.string.ic_description_consumption_level)
    )
}

/**
 * Component that displays an icon representing the consumption report.
 *
 * @param iconSize the size of the icon, default is medium.
 * @param hasUnresolvedAlerts indicates if the consumption is high, default is false.
 * @see IconSize
 * @see ConsumptionLevelIcon
 * @sample br.com.ecowatt.ui.components.device.Samples.ConsumptionReportIconSample
 */
@Composable
internal fun ConsumptionReportIcon(
    iconSize: IconSize = IconSize.MD,
    hasUnresolvedAlerts: Boolean
) {
    val containerColor =
        if (hasUnresolvedAlerts) MaterialTheme.colorScheme.onTertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer
    
    CustomIcon(
        size = iconSize,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        containerColor = containerColor,
        drawable = R.drawable.ic_priority_high,
        description = stringResource(R.string.ic_description_consumption_report)
    )
}

@Preview
@Composable
private fun LowConsumptionLevelIconPreview() {
    ConsumptionLevelIcon(
        isConsumptionHigh = false
    )
}

@Preview
@Composable
private fun HighConsumptionLevelIconPreview() {
    ConsumptionLevelIcon(
        isConsumptionHigh = true
    )
}

@Preview
@Composable
private fun ResolvedConsumptionReportIconPreview() {
    ConsumptionReportIcon(
        hasUnresolvedAlerts = false
    )
}

@Preview
@Composable
private fun UnresolvedConsumptionReportIconPreview() {
    ConsumptionReportIcon(
        hasUnresolvedAlerts = true
    )
}