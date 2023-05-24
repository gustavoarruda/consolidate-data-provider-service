package com.br.app.consolidatedataproviderservice.application.controller.v1

import com.br.app.consolidatedataproviderservice.application.payload.BalancePayload
import com.br.app.consolidatedataproviderservice.domain.entities.toPayload
import com.br.app.consolidatedataproviderservice.domain.service.BalanceReportService
import com.br.app.consolidatedataproviderservice.domain.service.BalanceService
import org.springframework.cache.annotation.Cacheable
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RequestMapping("v1/balance")
@RestController
class BalanceController(
    private val balanceService: BalanceService,
    private val balanceReportService: BalanceReportService
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

    @GetMapping("/report/{personId}")
    fun getDocument(
        @PathVariable(required = true) personId: String,
        @RequestParam(value="date") @DateTimeFormat(pattern="yyyy-MM-dd") date: LocalDate
    ): ResponseEntity<ByteArray> {
        return try {
            val balance = balanceService.getConsolidatedOfDay(personId, date)!!
            val byteArray = balanceReportService.createReport(balance)
            ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(byteArray)
        } catch (e: Exception) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}