plugins {
    java
    `maven-publish`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.3")
    implementation("com.bedrockk:molang:1.0-SNAPSHOT")
    implementation("com.google.code.gson:gson:2.8.9")
    compileOnly("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")

    testImplementation("com.google.code.gson:gson:2.8.9")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

group = "com.bedrockk"
version = "1.1.19-SNAPSHOT"

tasks.named<Test>("test") {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            pom {
                packaging = "jar"
                url.set("https://github.com/CloudburstMC/MoLang")

                scm {
                    connection.set("scm:git:git://github.com/CloudburstMC/MoLang.git")
                    developerConnection.set("scm:git:ssh://github.com/CloudburstMC/MoLang.git")
                    url.set("https://github.com/CloudburstMC/MoLang")
                }
            }
        }
    }
    repositories {
        maven {
            name = "maven-deploy"
            url = uri(
                System.getenv("MAVEN_DEPLOY_URL")
                    ?: "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            )
            credentials {
                username = System.getenv("MAVEN_DEPLOY_USERNAME") ?: "username"
                password = System.getenv("MAVEN_DEPLOY_PASSWORD") ?: "password"
            }
        }
    }
}
