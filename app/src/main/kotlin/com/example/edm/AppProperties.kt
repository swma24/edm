package com.example.edm

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding


@ConstructorBinding
@ConfigurationProperties("spring")
data class AppProperties(
    val user: User
) {
    data class User(
        val name: String
    )
}
