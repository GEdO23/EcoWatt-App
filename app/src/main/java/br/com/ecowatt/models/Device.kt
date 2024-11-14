package br.com.ecowatt.models

import java.math.BigDecimal

data class Device(
    val id: String,
    val name: String,
    val location: String,
    val type: String,
    val consumptionLimit: BigDecimal
)
