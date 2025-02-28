plugins {
  id("java-library")
  id("maven-publish")
  id("com.diffplug.spotless") version "6.11.0"
}

repositories {
  mavenCentral()
  maven {
    url = uri("https://s01.oss.sonatype.org/content/repositories/releases/")
  }
}

dependencies {
  api("com.squareup.okhttp3:okhttp:4.12.0")
  api("com.fasterxml.jackson.core:jackson-databind:2.17.2")
  api("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.17.2")
  api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.17.2")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
  testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

java {
  toolchain.languageVersion.set(JavaLanguageVersion.of(8))
  withSourcesJar()
  withJavadocJar()
}

tasks.withType<Javadoc>().configureEach {
  isFailOnError = false
  (options as StandardJavadocDocletOptions).addStringOption("Xdoclint:none", "-quiet")
}

spotless {
  java {
    palantirJavaFormat()
  }
}

group = "io.goatbytes"
version = "0.4.0"

tasks.jar {
  dependsOn(":generatePomFileForMavenPublication")
  archiveBaseName.set("server-sdk")
}

tasks.named<Jar>("sourcesJar") {
  archiveBaseName.set("server-sdk")
}

tasks.named<Jar>("javadocJar") {
  archiveBaseName.set("server-sdk")
}

tasks.test {
  useJUnitPlatform()
  testLogging.showStandardStreams = true
}
