import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.jetbrains.kotlin.jvm")
	id("org.jetbrains.kotlin.plugin.spring")
	id("org.springframework.boot")
	id("io.spring.dependency-management")
}


allprojects {
	group = "com.example"
	version = "1.0.0"

	repositories {
		mavenCentral()
		maven { url = uri("https://repo.spring.io/milestone") }
	}
}

subprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")

	java.sourceCompatibility = JavaVersion.VERSION_17

	extra["springCloudVersion"] = "2022.0.0-M4"
	dependencyManagement {
		imports {
			mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
		}
	}

	dependencies {
//		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//		implementation("org.jetbrains.kotlin:kotlin-reflect")
//		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "17"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

tasks.withType<BootJar> {
	enabled = false
}