package com.br.app.consolidatedataproviderservice.application.payload

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class BalancePayload(
    val id: String?,
    val date: LocalDate,
    val personId: String,
    val value: BigDecimal,
    val updateAt: LocalDateTime?
): java.io.Serializable