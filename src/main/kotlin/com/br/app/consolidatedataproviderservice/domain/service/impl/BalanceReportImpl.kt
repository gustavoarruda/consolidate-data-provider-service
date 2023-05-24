package com.br.app.consolidatedataproviderservice.domain.service.impl

import com.br.app.consolidatedataproviderservice.domain.entities.Balance
import com.br.app.consolidatedataproviderservice.domain.service.BalanceReportService
import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import org.springframework.stereotype.Service
import java.io.ByteArrayOutputStream

@Service
class BalanceReportImpl : BalanceReportService{
    override fun createReport(balance: Balance): ByteArray? {
        runCatching {
            return convertDocumentToByteArray(balance)
        }.onFailure { throw it }
        return null
    }

    fun convertDocumentToByteArray(balance: Balance): ByteArray {
        val document = Document()
        val outputStream = ByteArrayOutputStream()
        try {
            // Create a PdfWriter using the ByteArrayOutputStream
            val writer = PdfWriter.getInstance(document, outputStream)
            document.open()
            document.add(Paragraph("Balance Report"))
            document.add(Paragraph("Date: ${balance.date}"))
            document.add(Paragraph("Client: ${balance.personId}"))
            document.add(Paragraph("Balance: ${balance.value}"))
            document.add(Paragraph())
            document.close()
            return outputStream.toByteArray()
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        } finally {
            document.close()
        }
    }
}