package com.br.app.consolidatedataproviderservice.application.controller.v1

import com.br.app.consolidatedataproviderservice.application.payload.BalancePayload
import com.br.app.consolidatedataproviderservice.domain.entities.toPayload
import com.br.app.consolidatedataproviderservice.domain.service.BalanceService
import org.springframework.cache.annotation.Cacheable
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RequestMapping("v1/balance")
@RestController
class BalanceController(
    private val balanceService: BalanceService
) {
    @Cacheable(value = ["balanceByPersonId"], key = "#personId")
    @GetMapping("/person/{personId}")
    @ResponseStatus(HttpStatus.OK)
    fun getByPersonId(
        @PathVariable(required = true) personId: String,
        @RequestParam(value="date") @DateTimeFormat(pattern="yyyy-MM-dd") date: LocalDate
    ): BalancePayload? {
        return balanceService.getConsolidatedOfDay(personId, date)!!.toPayload()
    }
}