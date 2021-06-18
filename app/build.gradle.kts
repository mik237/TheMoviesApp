plugins {
    id("com.android.application")
    kotlin("android.extensions")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android{

    signingConfigs {
        create("release") {
            storeFile = file("../keystore/MoviesAppKeystore.jks")
            storePassword = "moviesapp"
            keyAlias = "key"
            keyPassword = "moviesapp"
        }
    }

    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion(Versions.buildTools)

    defaultConfig {
        applicationId = "com.ibrahim.themovieapp"
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Versions.code
        versionName = Versions.name

        multiDexEnabled = true

        buildConfigField ("String",  "BASEURL",      "\"https://api.themoviedb.org/3/discover/\"")
        buildConfigField ("String",  "POSTER_IMAGES_BASEURL",      "\"https://image.tmdb.org/t/p/w300\"")
        buildConfigField ("String",  "BACKDROP_IMAGES_BASEURL",      "\"https://image.tmdb.org/t/p/w780\"")
        buildConfigField ("String",  "API_KEY",      "\"91e7cf9e353076bc38be82a9b36f1f17\"")

        testInstrumentationRunner = Tests.androidJUnitRunner
    }

    buildTypes {
        getByName("debug"){
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }
        getByName("release"){
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false

            signingConfig = signingConfigs.getByName("release")
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures.viewBinding = true

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Dependencies.kotlin)

    implementation (Androidx.core)
    implementation (Androidx.appcompat)
    implementation (Androidx.material)
    implementation (Androidx.constraintlayout)

    //swipe to refresh
    implementation (Androidx.swipe_refresh_layout)


    //Retrofit
    implementation (Retrofit.retrofit)
    implementation (Retrofit.gson_converter)


    //Glide
    implementation (Dependencies.glide)


    //Hilt
    implementation (Hilt.hilt_android)
    kapt(Hilt.hilt_compiler)
    kapt(Hilt.hilt_android_compiler)


    //Navigation
    implementation (NavigationView.navigation_fragment)
    implementation (NavigationView.navigation_ui)


    testImplementation(Tests.junit)
    androidTestImplementation (Tests.ext_junit)
    androidTestImplementation (Tests.espresso_core)
}