package com.br.app.consolidatedataproviderservice.domain.service

import com.br.app.consolidatedataproviderservice.domain.entities.Balance

interface BalanceReportService {
    fun createReport(balance: Balance): ByteArray?
}