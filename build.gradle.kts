import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot")
	id("io.spring.dependency-management")
	kotlin("jvm")
	kotlin("plugin.spring")
}


allprojects {
	group = "com.example"
	version = "1.0.0"

	repositories {
		mavenCentral()
//		maven { url = uri("https://repo.spring.io/milestone") }
	}
}

subprojects {
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	java.sourceCompatibility = JavaVersion.VERSION_17
//	extra["springCloudVersion"] = "2022.0.0-M4"
	extra["springCloudVersion"] = "2021.0.4"

	dependencies {
		implementation("org.jetbrains.kotlin:kotlin-reflect")
//		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("org.springframework.cloud:spring-cloud-starter-task")
//    implementation("org.springframework.cloud:spring-cloud-stream")
//    implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka-streams")
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
		}
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = JavaVersion.VERSION_17.toString()
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

tasks.withType<BootJar> {
	enabled = false
}

tasks.withType<Jar> {
	enabled = false
}