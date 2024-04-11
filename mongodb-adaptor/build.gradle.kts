import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("java")
    id("org.springframework.boot") version "3.2.1" apply false
    id("io.spring.dependency-management") version "1.1.4"
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
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile>(){
    options.compilerArgs.add("-parameters")
}