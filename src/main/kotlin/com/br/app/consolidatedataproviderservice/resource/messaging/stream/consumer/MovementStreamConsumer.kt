package com.br.app.consolidatedataproviderservice.resource.messaging.stream.consumer

import com.br.app.consolidatedataproviderservice.domain.service.MovementService
import com.br.app.consolidatedataproviderservice.resource.messaging.entity.MovementStreamPayload
import com.br.app.consolidatedataproviderservice.resource.messaging.entity.toDomain
import org.springframework.context.annotation.Bean
import org.springframework.messaging.Message
import org.springframework.stereotype.Service
import java.util.function.Consumer

@Service
class MovementStreamConsumer(
    private val movementConsumerService: MovementService
) {
    @Bean("movementConsumer")
    fun movementPayloadConsumer(): Consumer<Message<MovementStreamPayload>> {
        return Consumer{
            movementConsumerService.process(it.payload.toDomain())
        }
    }
}
