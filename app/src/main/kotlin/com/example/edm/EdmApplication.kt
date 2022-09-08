package com.example.edm

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

//@EnableConfigurationProperties(AppProperties::class)
//@SpringBootApplication
//class EdmApplication (
//	val appProperties: AppProperties
//) {
//	@EventListener(ApplicationReadyEvent::class)
//	fun init() {
//		println("Hello ${appProperties.password}")
//	}
//}

@SpringBootApplication
class EdmApplication {

	@Value("\${password}")
	lateinit var password: String

	@EventListener(ApplicationReadyEvent::class)
	fun init() {
		println("Hello! password: $password")
	}
}

fun main(args: Array<String>) {
	runApplication<EdmApplication>(*args)
}

//@RestController
//class EdmController(
//	val appProperties: AppProperties
//) {
//	@GetMapping("/")
//	fun index(): String {
//		println(appProperties)
//		return appProperties.toString()
//	}
//}