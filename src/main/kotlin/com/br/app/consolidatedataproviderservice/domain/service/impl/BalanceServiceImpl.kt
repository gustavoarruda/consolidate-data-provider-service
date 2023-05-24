package com.br.app.consolidatedataproviderservice.domain.service.impl

import com.br.app.consolidatedataproviderservice.domain.entities.Balance
import com.br.app.consolidatedataproviderservice.domain.entities.toEntity
import com.br.app.consolidatedataproviderservice.domain.enums.TypeMovement
import com.br.app.consolidatedataproviderservice.domain.repository.BalanceRepository
import com.br.app.consolidatedataproviderservice.domain.service.BalanceService
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class BalanceServiceImpl(
    private val balanceRepository: BalanceRepository
) : BalanceService {
    override fun getConsolidatedOfDay(personId: String, date: LocalDate): Balance? {
        return balanceRepository.findByPersonIdAndDate(personId, date)
    }

    override fun updateBalanceConsolidatedOfDay(
        description: String,
        personId: String,
        date: LocalDate,
        value: BigDecimal,
        typeMovement: TypeMovement
    ) {
        val balanceUpdated = when (val balanceOfDay = getConsolidatedOfDay(personId, date)) {
            null -> Balance(
                date = date,
                personId = personId,
                value = value,
                createdAt = LocalDateTime.now(),
                updateAt = LocalDateTime.now()
            )

            else -> Balance(
                id = balanceOfDay.id,
                date = balanceOfDay.date,
                personId = personId,
                updateAt = LocalDateTime.now(),
                createdAt = balanceOfDay.createdAt,
                value = when (typeMovement) {
                    TypeMovement.CREDIT -> balanceOfDay.value + value
                    else -> balanceOfDay.value - value
                },
            )
        }
        balanceRepository.save(balanceUpdated.toEntity())
    }
}