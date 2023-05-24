package com.br.app.consolidatedataproviderservice.domain.entities.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "balance")
data class BalanceEntity(
    @Id
    val id: String? = UUID.randomUUID().toString().uppercase(),
    val date: LocalDate,
    val personId: String,
    val value: BigDecimal,
    @UpdateTimestamp
    val updateAt: LocalDateTime? = LocalDateTime.now(),
    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now()
)
