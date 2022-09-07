package com.example.edm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@EnableConfigurationProperties(AppProperties::class)
@SpringBootApplication
class EdmApplication

fun main(args: Array<String>) {
	runApplication<EdmApplication>(*args)
}

@RestController
class EdmController(
	val appProperties: AppProperties
) {

	@GetMapping("/")
	fun index(): String {
		println(appProperties.name)
		return appProperties.name
	}
}