plugins {
}

dependencies {
    implementation(project(":service"))
}

tasks.jar {
    enabled = false
}
