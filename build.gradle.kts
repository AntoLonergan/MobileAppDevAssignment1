import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    id("org.openjfx.javafxplugin") version "0.0.9"
}

javafx {
    modules = listOf("javafx.controls", "javafx.fxml", "javafx.web")
}



group = "food.review.app"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}




dependencies {
    testImplementation(kotlin("test"))
    implementation("org.slf4j:slf4j-simple:1.7.36")
    implementation ("io.github.microutils:kotlin-logging:2.1.23")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("no.tornado:tornadofx:1.7.19")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}