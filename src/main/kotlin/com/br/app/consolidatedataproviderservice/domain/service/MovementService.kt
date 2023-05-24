package com.br.app.consolidatedataproviderservice.domain.service

import com.br.app.consolidatedataproviderservice.domain.entities.Movement

interface MovementService {
    fun process(movement: Movement)
}