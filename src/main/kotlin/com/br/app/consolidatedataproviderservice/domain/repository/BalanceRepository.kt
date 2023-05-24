package com.br.app.consolidatedataproviderservice.domain.repository

import com.br.app.consolidatedataproviderservice.domain.entities.Balance
import com.br.app.consolidatedataproviderservice.domain.entities.entity.BalanceEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface BalanceRepository : CrudRepository<BalanceEntity, String> {
    fun findByPersonIdAndDate(personId: String, date: LocalDate): Balance?
}