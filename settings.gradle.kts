rootProject.name = "edm"

include("service")
include("app")
include("scheduler")

pluginManagement {
//	repositories {
//		gradlePluginPortal()
//		maven { url = uri("https://repo.spring.io/milestone") }
//	}
	plugins {
//		id("org.springframework.boot") version "3.0.0-M4"
		id("org.springframework.boot") version "2.7.3"
		id("io.spring.dependency-management") version "1.0.13.RELEASE"
//		id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"
		kotlin("jvm") version "1.7.10"
		kotlin("plugin.allopen") version "1.7.10"
		kotlin("plugin.noarg") version "1.7.10"
		kotlin("plugin.spring") version "1.7.10"
		kotlin("plugin.jpa") version "1.7.10"
//		kotlin("kapt") version "1.7.10"
	}
}
