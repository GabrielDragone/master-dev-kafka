package com.gabrieldragone.masterdevkafkaproducer.config

import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Configuration

@Configuration
class KafkaProducerConfig(
    private val kafkaProperties: KafkaProperties,
    @Value("\${topicos.pagamento.request.topic}") private val pagamentoRequestTopic: String
) {

    // Inicializa o producer factory utilizando o properties de cima:
    @Bean
    fun producerFactory(): ProducerFactory<String, PagamentoRequest> {
        val properties: Map<String, Object> = kafkaProperties.buildProducerProperties()
        return DefaultKafkaProducerFactory(properties)
    }

    // Cria a classe template utilizando a factory de cima:
    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, PagamentoRequest> {
        return KafkaTemplate(producerFactory())
    }

    @Bean
    fun pagamentoRequestTopic(): NewTopic {
        return TopicBuilder
            .name(pagamentoRequestTopic)
            .partitions(1)
            .replicas(1)
            .build()
    }

}