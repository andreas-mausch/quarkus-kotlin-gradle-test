import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.31"
    id("io.quarkus") version "0.15.0"
}

group = "de.neonew"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(enforcedPlatform("io.quarkus:quarkus-bom:0.15.0"))
    implementation("io.quarkus:quarkus-resteasy")

    testCompile("io.quarkus:quarkus-junit5:0.15.0")
    testCompile("io.rest-assured:rest-assured:3.3.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// https://github.com/quarkusio/quarkus/issues/1374
quarkus {
    setSourceDir("src/main/kotlin")
    resourcesDir().add(File("src/main/resources"))
    setOutputDirectory("build/classes/kotlin/main")
}
