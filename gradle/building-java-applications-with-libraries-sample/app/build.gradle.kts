/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("sample.java-application-conventions")
}

dependencies {
    implementation(project(":utilities"))
}

application {
    // Define the main class for the application.
    mainClass.set("sample.app.App")
}
