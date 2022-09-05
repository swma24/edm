import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
}

tasks.withType<BootJar> {
    enabled = false
}