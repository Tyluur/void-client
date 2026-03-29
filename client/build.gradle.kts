plugins {
    application
    id("com.gradleup.shadow") version "8.3.10"
}

group = "world.gregs.void"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("../libs/clientlibs.jar"))
}

java {
    sourceSets {
        main {
            java.srcDirs("src")
        }
    }
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }

    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

application {
    mainClass = "Loader"
}

tasks.shadowJar {
    minimize()
}