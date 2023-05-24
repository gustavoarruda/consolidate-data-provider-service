package com.br.app.consolidatedataproviderservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class ConsolidateDataProviderServiceApplication

fun main(args: Array<String>) {
	runApplication<ConsolidateDataProviderServiceApplication>(*args)
}
