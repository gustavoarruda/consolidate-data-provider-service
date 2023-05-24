package com.br.app.consolidatedataproviderservice.resource.messaging.entity

import com.br.app.consolidatedataproviderservice.domain.enums.TypeMovement
import com.br.app.consolidatedataproviderservice.domain.entities.Movement
import java.math.BigDecimal
import java.time.LocalDate

data class MovementStreamPayload(
    val id: String?,
    val description: String,
    val personId: String,
    val date: LocalDate,
    val typeMovement: String,
    val value: BigDecimal
): java.io.Serializable

fun MovementStreamPayload.toDomain() = Movement(
    description = description,
    personId = personId,
    date = date,
    typeMovement = TypeMovement.fromType(typeMovement),
    value = value,
    id = id
)