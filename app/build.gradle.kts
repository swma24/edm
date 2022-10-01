plugins {
}

dependencies {
    implementation(project(":domain"))
    runtimeOnly("org.springframework.boot:spring-boot-starter-actuator")
    runtimeOnly("org.springframework.cloud:spring-cloud-starter-vault-config")
    runtimeOnly("com.amazonaws:aws-java-sdk-core:1.12.305") // for Vault AWS_IAM authentication
//    implementation("org.springframework.boot:spring-boot-starter-quartz")
//    implementation("org.springframework.boot:spring-boot-starter-batch")
//    implementation("org.springframework.cloud:spring-cloud-starter-stream-kafka")
//    runtimeOnly("org.springframework.boot:spring-boot-admin-starter-server")
}

tasks.jar {
    enabled = false
}