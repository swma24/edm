plugins {
    kotlin("plugin.allopen")
    kotlin("plugin.noarg")
    kotlin("plugin.jpa")
//    id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.springframework.boot:spring-boot-starter-validation")
//    implementation("org.springframework.boot:spring-boot-starter-cache")
    runtimeOnly("mysql:mysql-connector-java")
    testRuntimeOnly("com.h2database:h2")
}

tasks.bootJar {
    enabled = false
}
