dependencies {
    implementation(project(":service"))
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-vault-config")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
