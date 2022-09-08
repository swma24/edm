package com.example.edm

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener

@SpringBootApplication
class EdmScheduler {

    @Value("\${password}")
    lateinit var password: String

    @EventListener(ApplicationReadyEvent::class)
    fun init() {
        println("Hello! password: $password")
    }
}

fun main(args: Array<String>) {
    runApplication<EdmScheduler>(*args)
}