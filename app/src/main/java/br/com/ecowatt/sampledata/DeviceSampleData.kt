package br.com.ecowatt.sampledata

import br.com.ecowatt.models.Consumption
import br.com.ecowatt.models.Device
import java.math.BigDecimal
import java.time.LocalDateTime

val deviceSampleData = Device(
    id = "-123",
    name = "Eletric shower",
    type = "Household appliance",
    location = "Bathroom",
    consumptionLimit = BigDecimal("356"),
    consumptions = listOf(
        Consumption(
            id = "-5",
            deviceId = "-123",
            consumption = BigDecimal("124"),
            dateTime = LocalDateTime.now()
        ),
        Consumption(
            id = "-4",
            deviceId = "-123",
            consumption = BigDecimal("356"),
            dateTime = LocalDateTime.now().minusMinutes(1)
        ),
        Consumption(
            id = "-3",
            deviceId = "-123",
            consumption = BigDecimal("128"),
            dateTime = LocalDateTime.now().minusMinutes(2)
        ),
        Consumption(
            id = "-2",
            deviceId = "-123",
            consumption = BigDecimal("32"),
            dateTime = LocalDateTime.now().minusMinutes(3)
        ),
        Consumption(
            id = "-1",
            deviceId = "-123",
            consumption = BigDecimal("0"),
            dateTime = LocalDateTime.now().minusMinutes(4)
        ),
    ),
    alerts = emptyList()
)