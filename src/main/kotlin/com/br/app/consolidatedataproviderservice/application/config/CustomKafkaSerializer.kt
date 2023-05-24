package com.br.app.consolidatedataproviderservice.application.config

import org.springframework.kafka.support.serializer.JsonSerializer

open class CustomKafkaSerializer<T>: JsonSerializer<T>(JsonParserBuilder.default())
