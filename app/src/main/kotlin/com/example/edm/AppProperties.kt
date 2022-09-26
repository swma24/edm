package com.example.edm

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding


@ConstructorBinding
@ConfigurationProperties("spring")
data class AppProperties(
    val datasource: DataSource
) {
    data class DataSource(
        val url: String
    )
}
