/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.5.1/userguide/building_java_projects.html
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    id("org.barfuin.gradle.taskinfo") version "2.0.0"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.0.1-jre")
    // https://mvnrepository.com/artifact/com.google.http-client/google-http-client
    implementation("com.google.http-client:google-http-client:1.42.2")

}

application {
    // Define the main class for the application.
    mainClass.set("tech.agiledev.App")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
    finalizedBy("msgAfterTest")
}

tasks.register("testWithMsg") {
    group="verification"
    description="test task post execution"
    dependsOn("test")

    doLast {
        println("Tests Done!")
    }
}

tasks.register("msgAfterTest") {
    group="verification"
    description="test task finalization"

    doLast {
        println("Tests Done!!")
    }
}

tasks.register<Copy>("backupTestXml") {
    from(layout.buildDirectory.dir("test-results/test/"))
    into(File("/tmp"))
    exclude("binary/**")
}