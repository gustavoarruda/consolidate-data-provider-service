package com.br.app.consolidatedataproviderservice.domain.entities

import com.br.app.consolidatedataproviderservice.domain.enums.TypeMovement
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class Movement(
    val id: String? = null,
    val description: String,
    val personId: String,
    val date: LocalDate,
    val typeMovement: TypeMovement,
    val value: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now()
)