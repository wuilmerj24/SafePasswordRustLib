plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    //Agregamos
    id("maven-publish")
}

android {
    namespace = "wuilmerj24.dev.safepasswordlib"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

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
    implementation("net.java.dev.jna:jna:5.12.0@aar")
}

//Configuramos esto
afterEvaluate {
    publishing {
        publications  {
            register<MavenPublication>("release"){
                groupId = "wuilmerj24.dev"
                artifactId = "safepasswordlib"
                version = "1.1.2"

                from(components["release"])

                pom {
                    name.set("Safe Password Rust Libb")
                    description.set("# SafePasswordApp \uD83D\uDD10\n"+
                        "\n"+
                        "Aplication etc"
                    )
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
                            name.set("wuilmer")
                        }
                    }

                    scm {
                        connection.set("scm:git:github.com/wuilmerj24/SafePasswordRustLib.git")
                        developerConnection.set("scm:git:ssh://github.com/wuilmerj24/SafePasswordRustLib.git")
                        url.set("https://github.com/wuilmerj24/SafePasswordRustLib.git")
                    }
                }
            }
        }

        repositories{
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/wuilmmerj24/SafePasswordRustLib")

                credentials{
                    username= System.getenv("GITHUB_USERNAME")
                    password = System.getenv("GITHUB_PASSWORD")
                }
            }
        }
    }
}