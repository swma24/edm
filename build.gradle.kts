import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar


plugins {
	val kotlinVersion = "1.7.10"
	id("org.springframework.boot") version "2.7.3"
	id("io.spring.dependency-management") version "1.0.13.RELEASE"
//		id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"
	kotlin("jvm") version kotlinVersion
	kotlin("kapt") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	kotlin("plugin.jpa") version kotlinVersion
	kotlin("plugin.allopen") version kotlinVersion
	kotlin("plugin.noarg") version kotlinVersion
}


allprojects {
	group = "com.example"
	version = "1.0.0"

	repositories {
		mavenCentral()
	}
}

subprojects {
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	dependencies {
		annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
//		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.springframework.boot:spring-boot-starter-web")
		runtimeOnly("org.springframework.boot:spring-boot-starter-actuator")
		runtimeOnly("org.springframework.cloud:spring-cloud-starter-vault-config")
		runtimeOnly("com.amazonaws:aws-java-sdk-core:1.12.305") // for Vault AWS_IAM authentication
		testImplementation("org.springframework.boot:spring-boot-starter-test")
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.4")
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
