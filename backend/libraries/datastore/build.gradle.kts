plugins {
    id("java")
}

group = "org.edunavigator"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("software.amazon.awssdk:bom:2.28.22"))
    implementation("software.amazon.awssdk:dynamodb")
    implementation("redis.clients:jedis:5.2.0")
    implementation("org.springframework:spring-context:6.1.14")
    implementation(project(":libraries:core"))
    // https://mvnrepository.com/artifact/org.mockito/mockito-core
    testImplementation("org.mockito:mockito-core:5.14.2")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}