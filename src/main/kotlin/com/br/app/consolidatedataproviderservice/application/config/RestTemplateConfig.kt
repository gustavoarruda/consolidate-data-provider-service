package com.br.app.consolidatedataproviderservice.application.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RestTemplateConfig {
    @Bean
    fun objectMapper() = JsonParserBuilder.default()
}