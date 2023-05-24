package com.br.app.consolidatedataproviderservice.domain.service

import com.br.app.consolidatedataproviderservice.domain.entities.Balance
import com.br.app.consolidatedataproviderservice.domain.enums.TypeMovement
import java.math.BigDecimal
import java.time.LocalDate

interface BalanceService {
    fun getConsolidatedOfDay(personId: String, date: LocalDate): Balance?
    fun updateBalanceConsolidatedOfDay(
        description: String,
        personId: String,
        date: LocalDate,
        value: BigDecimal,
        typeMovement: TypeMovement
    )
}