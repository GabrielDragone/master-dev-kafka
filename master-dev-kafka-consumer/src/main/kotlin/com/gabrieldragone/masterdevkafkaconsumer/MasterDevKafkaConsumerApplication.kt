package com.gabrieldragone.masterdevkafkaconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MasterDevKafkaConsumerApplication

fun main(args: Array<String>) {
	runApplication<MasterDevKafkaConsumerApplication>(*args)
}
