plugins {
}

dependencies {
    implementation(project(":service"))
    implementation("org.springframework.boot:spring-boot-starter-actuator")
}

tasks.jar {
    enabled = false
}
