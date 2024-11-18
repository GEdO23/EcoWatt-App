package br.com.ecowatt.models

import java.time.LocalDateTime

data class Alert(
    val id: String,
    val deviceId: String,
    val message: String,
    val dateTime: LocalDateTime
)
