

object Versions{
    const val gradle = "4.1.3"
    const val kotlin = "1.4.32"//1.3.72
    const val hilt = "2.35"
    const val compileSdk = 30
    const val buildTools = "30.0.2"
    const val minSdk = 21
    const val targetSdk = 30
    const val navigationView = "2.3.5"
    const val retrofit = "2.9.0"
    const val coroutines = "1.4.1"
    const val code = 1
    const val name = "1.0"
}


object Androidx{
    const val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    const val extensions = "android.arch.lifecycle:extensions:1.1.1"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
    const val legacy_support_v4 = "androidx.legacy:legacy-support-v4:1.0.0"
    const val appcompat = "androidx.appcompat:appcompat:1.3.0"
    const val activity = "androidx.activity:activity-ktx:1.2.2"
    const val fragment = "androidx.fragment:fragment:1.3.3"
    const val material = "com.google.android.material:material:1.3.0"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.4"
    const val core = "androidx.core:core-ktx:1.5.0"
    const val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
    const val swipe_refresh_layout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
}

object Tests{
    const val androidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val junit = "junit:junit:4.13.2"
    const val ext_junit = "androidx.test.ext:junit:1.1.2"
    const val espresso_core = "androidx.test.espresso:espresso-core:3.3.0"
}


object Dependencies{
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val recyclerview = "androidx.recyclerview:recyclerview:1.2.0"
    const val glide = "com.github.bumptech.glide:glide:4.12.0"
}


object Retrofit{
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson_converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
}

object Hilt{
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hilt_compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
}

object NavigationView{
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationView}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigationView}"
}

object Coroutines{
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}
