package br.com.ecowatt.models.device

import br.com.ecowatt.models.Consumption
import java.math.BigDecimal
import java.time.LocalDateTime

/**
 * Object containing sample data for the Device class.
 */
object DeviceSampleData {
    
    /**
     * Sample data for a device with low consumption level.
     */
    val lowConsumptionLevelDevice = Device(
        id = "-123",
        name = "Electric shower",
        type = "Household appliance",
        location = "Bathroom",
        consumptionLimit = BigDecimal("356"),
        consumptions = listOf(
            Consumption(
                id = "-abc",
                deviceId = "-123",
                consumption = BigDecimal("200"),
                dateTime = LocalDateTime.now()
            )
        ),
        alerts = emptyList()
    )

    /**
     * Sample data for a device with high consumption level.
     */
    val highConsumptionLevelDevice = Device(
        id = "-123",
        name = "Electric shower",
        type = "Household appliance",
        location = "Bathroom",
        consumptionLimit = BigDecimal("356"),
        consumptions = listOf(
            Consumption(
                id = "-abc",
                deviceId = "-123",
                consumption = BigDecimal("400"),
                dateTime = LocalDateTime.now()
            )
        ),
        alerts = emptyList()
    )

    /**
     * List of devices with varying consumption levels.
     */
    val listOfDeviceConsumptionLevels = listOf(
        lowConsumptionLevelDevice,
        lowConsumptionLevelDevice,
        highConsumptionLevelDevice,
        highConsumptionLevelDevice,
        lowConsumptionLevelDevice,
        highConsumptionLevelDevice,
    )
}
