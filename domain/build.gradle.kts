plugins {
    kotlin("plugin.allopen")
    kotlin("plugin.noarg")
    kotlin("plugin.jpa")
//    id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("mysql:mysql-connector-java:8.0.30")
    testRuntimeOnly("com.h2database:h2")
}

tasks.bootJar {
    enabled = false
}
