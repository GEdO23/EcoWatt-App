package br.com.ecowatt.sampledata

import br.com.ecowatt.models.Device
import java.math.BigDecimal

val deviceSampleData = Device(
    id = "id",
    name = "name",
    type = "type",
    location = "location",
    consumptionLimit = BigDecimal.ZERO
)