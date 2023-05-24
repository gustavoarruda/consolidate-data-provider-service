package com.br.app.consolidatedataproviderservice.domain.entities

import com.br.app.consolidatedataproviderservice.application.payload.BalancePayload
import com.br.app.consolidatedataproviderservice.domain.entities.entity.BalanceEntity
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

data class Balance(
    val id: String? = UUID.randomUUID().toString(),
    val date: LocalDate,
    val personId: String,
    val value: BigDecimal,
    val updateAt: LocalDateTime?,
    val createdAt: LocalDateTime
)

fun Balance.toPayload() = BalancePayload(
    id = id,
    date = date,
    personId = personId,
    value = value,
    updateAt = updateAt
)

fun Balance.toEntity() = BalanceEntity(
    id = id,
    date = date,
    personId = personId,
    value = value,
    updateAt = updateAt,
    createdAt = createdAt
)