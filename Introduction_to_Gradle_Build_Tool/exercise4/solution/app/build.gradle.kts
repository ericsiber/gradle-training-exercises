/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.4.2/userguide/building_java_projects.html
 */

plugins {
    application
    id("shared-build-conventions")
}

dependencies {
    implementation(project(":model"))
    implementation("com.google.http-client:google-http-client:1.41.8")
}

application {
    mainClass.set("com.gradle.lab.App")
}
