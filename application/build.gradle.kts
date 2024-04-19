plugins {
	id("java")
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.jlg.submatch"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(project(":domain"))
	implementation(project(":host"))
	implementation(project(":http-adaptor"))
	implementation(project(":security"))
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

springBoot {
	buildInfo()
	mainClass = "com.jlg.submatch.service.authentication.ServiceAuthenticationApplication"
}

tasks.withType<JavaCompile>(){
	options.compilerArgs.add("-parameters")
}
