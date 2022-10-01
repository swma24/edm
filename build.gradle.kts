plugins {
	val kotlinVersion = "1.7.10"
	id("org.springframework.boot") version "2.7.3"
	id("io.spring.dependency-management") version "1.0.13.RELEASE"
	kotlin("jvm") version kotlinVersion
	kotlin("kapt") version kotlinVersion
	kotlin("plugin.allopen") version kotlinVersion
	kotlin("plugin.noarg") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	kotlin("plugin.jpa") version kotlinVersion
}


allprojects {
	group = "com.example"
	version = "1.0.0"

	repositories {
		mavenCentral()
	}
}

subprojects {
	apply {
		plugin("org.springframework.boot")
		plugin("io.spring.dependency-management")
		plugin("org.jetbrains.kotlin.jvm")
		plugin("kotlin-kapt")
		plugin("org.jetbrains.kotlin.plugin.spring")
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.4")
		}
	}

	dependencies {
		kapt("org.springframework.boot:spring-boot-configuration-processor")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("org.springframework.boot:spring-boot-starter-log4j2")
		implementation("com.fasterxml.jackson.core:jackson-databind")
		runtimeOnly("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")
		testImplementation("org.springframework.boot:spring-boot-starter-test") {
			exclude(module = "mockito-core")
		}
		testImplementation("com.ninja-squad:springmockk:3.1.1")

		modules {
			module("org.springframework.boot:spring-boot-starter-logging") {
				replacedBy("org.springframework.boot:spring-boot-starter-log4j2")
			}
		}
	}

	tasks {
		compileKotlin {
			kotlinOptions {
				freeCompilerArgs = listOf("-Xjsr305=strict")
				jvmTarget = "17"
			}
		}
		test {
			useJUnitPlatform()
		}
	}
}

tasks {
	bootJar {
		enabled = false
	}
	jar {
		enabled = false
	}
}
