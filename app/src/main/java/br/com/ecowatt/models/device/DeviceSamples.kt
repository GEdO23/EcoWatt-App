package br.com.ecowatt.models.device

import java.math.BigDecimal

/**
 * Contains sample functions for the Device class.
 */
object DeviceSamples {

    /**
     * Sample function demonstrating the usage of the Device class.
     */
    @JvmStatic
    fun deviceSample(): Device {
        val device = Device(
            id = "-OC57qYvoZoHsHvvflyJ",
            name = "Air Conditioner",
            location = "Office",
            type = "Quality of Life",
            consumptionLimit = BigDecimal(66)
        )
        println(device)
        return device
    }
}