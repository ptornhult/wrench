plugins {
    id("com.android.library")
}

android {
    compileSdkVersion(Versions.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    lintOptions {
        baselineFile = file("lint-baseline.xml")
        isCheckReleaseBuilds = true
        isAbortOnError = true
        isWarningsAsErrors = true
        setLintConfig(File("../lint.xml"))
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

// The api of this module should be discussed before any potential release
// apply from: rootProject.file('gradle/gradle-mvn-push.gradle')