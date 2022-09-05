package com.example.edm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EdmApplication

fun main(args: Array<String>) {
	runApplication<EdmApplication>(*args)
}
