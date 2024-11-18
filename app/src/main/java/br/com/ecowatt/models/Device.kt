package br.com.ecowatt.models

import java.math.BigDecimal

/**
 * Data class representing a Device.
 *
 * @property id The unique identifier of the device.
 * @property name The name of the device.
 * @property location The location where the device is installed.
 * @property type The type/category of the device.
 * @property consumptionLimit The maximum allowed consumption for the device.
 * @property consumptions A list of consumption records associated with the device.
 * @property alerts A list of alerts related to the device.
 */
data class Device(
    val id: String,
    val name: String,
    val location: String,
    val type: String,
    val consumptionLimit: BigDecimal,
    val consumptions: List<Consumption>,
    val alerts: List<Alert>
)
