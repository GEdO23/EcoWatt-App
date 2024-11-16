package br.com.ecowatt.models

import java.math.BigDecimal

/**
 * Data class representing a device.
 *
 * @property id The unique identifier of the device.
 * @property name The name of the device.
 * @property location The location where the device is installed.
 * @property type The type/category of the device.
 * @property consumptionLimit The consumption limit of the device.
 */
data class Device(
    val id: String,
    val name: String,
    val location: String,
    val type: String,
    val consumptionLimit: BigDecimal
)
