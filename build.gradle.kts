import java.net.URI

plugins {
  kotlin("jvm") version "2.0.0"
  `maven-publish`
  signing
}

group = "io.goatbytes"
version = "0.4.0"

repositories {
  mavenCentral()
}

dependencies {
  api("com.squareup.okhttp3:okhttp:4.12.0")
  api("com.fasterxml.jackson.core:jackson-databind:2.17.2")
  api("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.17.2")
  api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.17.2")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
  testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

kotlin {
  jvmToolchain(17)
}

tasks.withType<Javadoc>().configureEach {
  isFailOnError = false
  (options as StandardJavadocDocletOptions).addStringOption("Xdoclint:none", "-quiet")
}

val javadocJar by tasks.registering(Jar::class) {
  archiveClassifier.set("javadoc")
  from(tasks.withType<Javadoc>())
}

val sourcesJar by tasks.registering(Jar::class) {
  archiveClassifier.set("sources")
  from(sourceSets.main.get().allSource)
}

tasks.test {
  useJUnitPlatform()
  testLogging.showStandardStreams = true
}

/**
 * Defines constants for SCM (Software Configuration Management) related to the project.
 */
object SCM {
  const val HOST = "github.com"
  const val ORG = "goatbytes"
  const val NAME = "vapi-sdk-java"
  const val PATH = "$HOST/$ORG/$NAME"
}

/**
 * Contains the License name and URL for the project.
 */
object License {
  const val NAME = "Apache 2.0"
  const val URL = "https://${SCM.PATH}/blob/main/LICENSE"
}

/**
 * Contains the developer metadata for the POM.
 */
object Developer {
  const val ID = "goatbytes"
  const val NAME = "GoatBytes.IO"
  const val EMAIL = "engineering@goatbytes.io"
  const val URL = "https://goatbytes.io"
  const val TIMEZONE = "America/Los_Angeles"
}

internal object Publishing {
  const val ARTIFACT_ID = "vapi-sdk-java"
  const val NAME = "vapi-sdk-java"
  const val DESCRIPTION = "VAPI Java SDK"
  const val URL = "https://${SCM.ORG}.github.io/${SCM.NAME}"
  const val MAVEN_NAME = "MavenCentral"
  const val MAVEN_URL = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
  const val MAVEN_SNAPSHOT_URL = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
  val ENV_NAME_CREDENTIALS: String get() = "${ARTIFACT_ID.replace("-", "_")}_CREDENTIALS"
}

/**
 * Represents the configuration for signing artifacts, encapsulating necessary details.
 */
sealed class SigningConfig {

  abstract val credentials: Credentials

  class Release(override val credentials: Credentials) : SigningConfig() {

    companion object {
      @Suppress("TooGenericExceptionCaught")
      operator fun get(project: Project): Release? {
        return try {
          val file = File(project.prop(Publishing.ENV_NAME_CREDENTIALS))
          val credentials = Credentials.from(file) ?: return null
          Release(credentials)
        } catch (e: Exception) {
          null
        }
      }
    }
  }

  data class Credentials(
    val keyId: String,
    val keyRing: String,
    val password: String
  ) {
    companion object {
      fun from(file: File): Credentials? {
        var keyId: String? = null
        var keyring: String? = null
        var password: String? = null
        file.forEachLine { line ->
          if (line.contains("=")) {
            val key = line.substringBefore("=")
            val value = line.substringAfter("=")
            when (key) {
              KEY_ID -> keyId = value
              KEYRING -> keyring = value
              PASSWORD -> password = value
            }
          }
        }
        return let(keyId, keyring, password) { id, key, pass ->
          Credentials(id, key, pass)
        }
      }
    }
  }

  private companion object {
    private const val KEY_ID = "SIGNING_KEY_ID"
    private const val KEYRING = "SIGNING_KEYRING"
    private const val PASSWORD = "SIGNING_PASSWORD"

    private fun <A, B, C, D> let(a: A?, b: B?, c: C?, block: (a: A, b: B, c: C) -> D): D? {
      return if (a != null && b != null && c != null) block(a, b, c) else null
    }

    private infix fun Project.prop(name: String): String {
      return (System.getenv(name) ?: findProperty(name)) as String
    }
  }
}

publishing {
  repositories {
    maven {
      name = Publishing.MAVEN_NAME
      url = if (version.toString().contains("SNAPSHOT")) {
        URI(Publishing.MAVEN_SNAPSHOT_URL)
      } else {
        URI(Publishing.MAVEN_URL)
      }
      credentials {
        username = System.getenv("OSSRH_USERNAME")
        password = System.getenv("OSSRH_PASSWORD")
      }
    }
  }

  publications {
    create<MavenPublication>("mavenJava") {
      from(components["java"])

      artifact(tasks.jar.get()) {
        classifier = "javadoc"
      }

      artifact(sourcesJar.get()) {
        classifier = "sources"
      }

      pom {
        name.set(Publishing.NAME)
        description.set(Publishing.DESCRIPTION)
        url.set(Publishing.URL)
        licenses {
          license {
            name.set(License.NAME)
            url.set(License.URL)
            distribution.set("repo")
          }
        }
        developers {
          developer {
            id.set(Developer.ID)
            name.set(Developer.NAME)
            email.set(Developer.EMAIL)
            url.set(Developer.URL)
            timezone.set(Developer.TIMEZONE)
          }
        }
        scm {
          url.set("https://${SCM.PATH}/")
          connection.set("scm:git:git://${SCM.PATH}.git")
          developerConnection.set("scm:git:ssh://git@${SCM.PATH}.git")
        }
      }
    }
  }
}

signing {
  SigningConfig.Release[project]?.credentials?.run {
    useInMemoryPgpKeys(keyId, keyRing, password)
    sign(publishing.publications)
  }
}
