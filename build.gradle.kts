plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "upinn.tech.safepasswordlib"
    compileSdk = 36

    defaultConfig {
        minSdk = 25

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation("net.java.dev.jna:jna:5.17.0@aar")
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = "upinn.tech"
                artifactId = "safepasswordlib"
                version = "1.0.7"

                from(components["release"])

                pom {
                    name.set("Safe Password Rust Lib")
                    description.set("# SafePasswordApp \uD83D\uDD10\n" +
                            "\n" +
                            "Aplicación **Android (Jetpack Compose)** que utiliza la librería **Rust `safe_password`** creada en la **Parte 1**.  \n" +
                            "\n" +
                            "Permite:\n" +
                            "- Generar contraseñas seguras.  \n" +
                            "- Verificar la fuerza de las contraseñas (Weak, Moderate, Strong).  ")
                    url.set("https://github.com/wuilmerj24/SafePasswordRustLib.git")
                    licenses {
                        license {
                            name.set("Apache-2.0 license")
                            url.set("https://github.com/wuilmerj24/SafePasswordRustLib/blob/main/LICENSE")
                            distribution.set("repo")
                        }
                    }
                    developers {
                        developer {
                            id.set("wuilmerj24")
                            name.set("Upinn ")
                        }
                    }
                    scm {
                        connection.set("scm:git:github.com/wuilmerj24/SafePasswordRustLib.git")
                        developerConnection.set("scm:git:ssh://github.com/wuilmerj24/SafePasswordRustLib.git")
                        url.set("https://github.com/wuilmerj24/SafePasswordRustLib/tree/main")
                    }
                }
            }
        }

        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/wuilmerj24/SafePasswordRustLib")
                credentials {
                    username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
                    password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
                }
            }
        }
    }
}
