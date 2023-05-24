package com.br.app.consolidatedataproviderservice.domain.service.impl

import com.br.app.consolidatedataproviderservice.domain.entities.Movement
import com.br.app.consolidatedataproviderservice.domain.service.BalanceService
import com.br.app.consolidatedataproviderservice.domain.service.MovementService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Caching
import org.springframework.stereotype.Service

@Service
class MovementServiceImpl(
    private val balanceService: BalanceService,
) : MovementService {
    @CacheEvict(value = ["balanceByPersonId"], key = "#movement.personId")
    override fun process(movement: Movement) {
        balanceService.updateBalanceConsolidatedOfDay(
            movement.description,
            movement.personId,
            movement.date,
            movement.value,
            movement.typeMovement
        )
    }
}