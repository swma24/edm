plugins {
}

dependencies {
    implementation(project(":domain"))
    runtimeOnly("org.springframework.boot:spring-boot-starter-actuator")
    runtimeOnly("org.springframework.cloud:spring-cloud-starter-vault-config")
    runtimeOnly("com.amazonaws:aws-java-sdk-core:1.12.305") // for Vault AWS_IAM authentication
//    implementation("org.springframework.cloud:spring-cloud-starter-task")
//    implementation("org.springframework.cloud:spring-cloud-stream")
//    implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka-streams")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.4")
    }
}

tasks.jar {
    enabled = false
}