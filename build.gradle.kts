plugins {
    kotlin("multiplatform") version "1.7.10"
}

group = "me.gedar"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(BOTH) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    val versions = object {
        val retrofit = "2.9.0"
        val coroutines = "1.6.4"
    }

    
    sourceSets {
        val commonMain by getting {
            dependencies {
                //Retrofit
                implementation("com.squareup.retrofit2:retrofit:${versions.retrofit}")
                implementation("com.squareup.retrofit2:converter-gson:${versions.retrofit}")
                //Coroutines
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${versions.coroutines}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${versions.coroutines}")
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}


