import org.springframework.boot.gradle.plugin.SpringBootPlugin
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("java")
    id("io.spring.dependency-management") version "1.1.4"
    id("org.springframework.boot") version "3.2.1" apply false
    id("jacoco")
    id("java-test-fixtures")
}

group = "com.jlg.submatch.service.user"
version = "unspecified"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom(SpringBootPlugin.BOM_COORDINATES)
    }
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testFixturesApi("org.projectlombok:lombok")
    testFixturesImplementation("org.projectlombok:lombok")
    testFixturesAnnotationProcessor("org.projectlombok:lombok")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile>(){
    options.compilerArgs.add("-parameters")
}