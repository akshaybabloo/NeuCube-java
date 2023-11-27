plugins {
    id("java")
}

group = "nz.ac.aut"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-core:2.11.2")
    implementation("org.apache.logging.log4j:log4j-api:2.11.2")
    implementation("com.thoughtworks.xstream:xstream:1.4.8")
    implementation("org.apache.commons:commons-math3:3.6.1")
    implementation("org.controlsfx:controlsfx:8.0.6_20")
    implementation("org.quartz-scheduler:quartz-jobs:2.2.3")
    implementation("org.quartz-scheduler:quartz:2.2.3")
    implementation("xmlpull:xmlpull:1.1.3.1")
    implementation("xpp3:xpp3_min:1.1.4c")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}