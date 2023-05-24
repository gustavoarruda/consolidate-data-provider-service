package com.br.app.consolidatedataproviderservice.application.payload

import com.br.app.consolidatedataproviderservice.domain.entities.Movement
import com.br.app.consolidatedataproviderservice.domain.enums.TypeMovement
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class MovementPayload(
    val id: String?,
    val description: String,
    val personId: String,
    val date: LocalDate,
    val typeMovement: String,
    val value: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now()
): java.io.Serializable

fun MovementPayload.toDomain() = Movement(
    description = description,
    personId = personId,
    date = date,
    typeMovement = TypeMovement.fromType( typeMovement.uppercase() ),
    value = value,
    id = id
)