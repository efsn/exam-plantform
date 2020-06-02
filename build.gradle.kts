plugins {
    val kotlinVersion = "1.3.72"

    application
    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    kotlin("plugin.allopen") version kotlinVersion
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

group = "cn.ddd"
version = "1.0.0-SNAPSHOT"

apply(from = rootProject.file("gradle/ktlint.gradle.kts"))

repositories {
    mavenCentral()
    jcenter()
}

configurations.create("developmentOnly")

dependencies {
    val micronautVersion = "2.0.0.M3"

    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-http-server-netty")
    implementation("io.micronaut:micronaut-runtime")
    implementation("javax.annotation:javax.annotation-api")
    implementation("io.swagger.core.v3:swagger-annotations")

    runtimeOnly("ch.qos.logback:logback-classic:1.2.3")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")

    kapt(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    kapt("io.micronaut:micronaut-inject-java")
    kapt("io.micronaut:micronaut-validation")

    testImplementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    testImplementation("io.micronaut.test:micronaut-test-kotlintest")
    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.2")

    kaptTest(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    kaptTest("io.micronaut:micronaut-inject-java")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
            freeCompilerArgs = listOf("-Xjsr305=strict")
            javaParameters = true
        }
    }

    compileTestKotlin {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
            javaParameters = true
        }
    }

    test {
        failFast = true
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
        classpath += configurations.getByName("developmentOnly")
    }

    shadowJar {
        mergeServiceFiles()
    }

    withType<JavaExec> {
        classpath += configurations.getByName("developmentOnly")
        jvmArgs("-noverify", "-XX:TieredStopAtLevel=1", "-Dcom.sun.management.jmxremote")
    }
}

allOpen {
    annotation("io.micronaut.aop.Around")
}

application {
    mainClassName = "cn.ddd.examination.Application"
}