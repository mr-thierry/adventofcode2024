plugins {
    kotlin("jvm") version "2.1.0"
}

sourceSets {
    main {
        kotlin.srcDir("src")
    }
}

tasks {
    wrapper {
        gradleVersion = "8.11.1"
    }
}


dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.9.0")
    implementation("com.willowtreeapps.assertk:assertk-jvm:0.25")
}
