package br.com.ecowatt.models

import java.math.BigDecimal
import java.time.LocalDateTime

data class Consumption(
    val id: String,
    val deviceId: String,
    val consumption: BigDecimal,
    val dateTime: LocalDateTime
)
