import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("java")
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
    id("jacoco")
    id("java-test-fixtures")
}

group = "com.jlg.submatch"
version = "0.0.1-SNAPSHOT"

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
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.4.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation((testFixtures(project(":domain"))))
    compileOnly("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.3")
    testFixturesApi("org.projectlombok:lombok")
    testFixturesImplementation("org.projectlombok:lombok")
    testFixturesImplementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.3")
    testFixturesAnnotationProcessor("org.projectlombok:lombok")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile>(){
    options.compilerArgs.add("-parameters")
}