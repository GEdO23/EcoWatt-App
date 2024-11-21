package br.com.ecowatt.sampledata

import br.com.ecowatt.models.Consumption
import br.com.ecowatt.models.Device
import java.math.BigDecimal
import java.time.LocalDateTime

object DeviceSampleData {
    
    val lowConsumptionLevelDevice = Device(
        id = "-123",
        name = "Eletric shower",
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
    
    val highConsumptionLevelDevice = Device(
        id = "-123",
        name = "Eletric shower",
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
    
    val listOfDeviceConsumptionLevels = listOf(
        lowConsumptionLevelDevice,
        lowConsumptionLevelDevice,
        highConsumptionLevelDevice,
        highConsumptionLevelDevice,
        lowConsumptionLevelDevice,
        highConsumptionLevelDevice,
    )
}
