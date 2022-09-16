import org.springframework.boot.gradle.tasks.bundling.BootJar


plugins {
}

dependencies {
}

tasks.withType<BootJar> {
    enabled = false
}