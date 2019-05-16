package dependencies

const val COMPILE_SDK = 28
const val MIN_SDK = 25
const val TARGET_SDK = 28

private const val VKOTLIN = "1.3.31"
private const val VNAVIGATION = "1.0.0"

const val ANDROID_PLUGIN = "com.android.tools.build:gradle:3.5.0-beta01"
const val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$VKOTLIN"
const val SAFEARGS_PLUGIN = "android.arch.navigation:navigation-safe-args-gradle-plugin:$VNAVIGATION"
const val VERSIONS_PLUGIN = "com.github.ben-manes:gradle-versions-plugin:0.20.0"

private const val VCOUROUTINE = "1.1.1"
const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:$VKOTLIN"
const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VCOUROUTINE"
const val UI_COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VCOUROUTINE"

const val KTX = "androidx.core:core-ktx:1.1.0-alpha04"
const val ACTIVITYX = "androidx.activity:activity-ktx:1.0.0-alpha03"
const val FRAGMENTX = "androidx.fragment:fragment-ktx:1.1.0-alpha03"

const val APPCOMPAT = "androidx.appcompat:appcompat:1.1.0-alpha02"
const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:1.1.0-alpha02"
const val CONSTRAINTLAYOUT = "androidx.constraintlayout:constraintlayout:2.0.0-alpha5"
const val CARDVIEW = "androidx.cardview:cardview:1.0.0"

const val CONTENTPAGER = "androidx.contentpager:contentpager:1.0.0-rc01"
const val WEBKIT = "androidx.webkit:webkit:1.0.0"
const val MEDIA2 = "androidx.media2:media2:1.0.0-alpha04"

const val MATERIAL = "com.google.android.material:material:1.1.0-alpha03"
const val PAGING = "androidx.paging:paging-runtime:2.1.0"
const val BROWSER = "androidx.browser:browser:1.0.0"
const val NAVIGATION = "android.arch.navigation:navigation-fragment-ktx:$VNAVIGATION"
const val NAVIGATION_UI = "android.arch.navigation:navigation-ui-ktx:$VNAVIGATION"

private const val VROOM = "2.1.0-alpha04"
const val ROOM_COMMON = "androidx.room:room-common:$VROOM"
const val ROOM_RUNTIME = "androidx.room:room-runtime:$VROOM"
const val ROOM_COMPILER = "androidx.room:room-compiler:$VROOM"

const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0-alpha03"
const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:2.1.0-alpha03"
const val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:2.0.0"
const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:2.1.0-alpha03"

const val BIOMETRIC = "androidx.biometric:biometric:1.0.0-alpha03"

const val EMOJI = "androidx.emoji:emoji:1.0.0"
const val EMOJI_COMPAT = "androidx.emoji:emoji-appcompat:1.0.0"
const val EMOJI_BUNDLED = "androidx.emoji:emoji-bundled:1.0.0"

const val SAVEDSTATE = "androidx.savedstate:savedstate:1.0.0-alpha02"
const val SAVEDSTATE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-savedstate:1.0.0-alpha01"

const val VIEWPAGER2 = "androidx.viewpager2:viewpager2:1.0.0-alpha04"

const val RECOMMENDATION = "androidx.recommendation:recommendation:1.0.0"

const val PREFERENCE = "androidx.preference:preference-ktx:1.1.0-alpha03"

const val MULTIDEX = "androidx.multidex:multidex:2.0.0"

const val RXWEBVIEW = "com.github.satoshun.RxWebView:rxwebview-kotlin:2.3.0"

const val RXJAVA = "io.reactivex.rxjava2:rxjava:2.2.0"
const val RXANDROID = "io.reactivex.rxjava2:rxandroid:2.1.0"

const val GROUPIE = "com.xwray:groupie:2.3.0"
const val GROUPIE_DATABINDING = "com.xwray:groupie-databinding:2.3.0"

const val WORK_MANAGER = "androidx.work:work-runtime-ktx:2.0.0-rc01"

const val CAMERAX = "androidx.camera:camera-camera2:1.0.0-alpha02"
const val CAMERAX_VIEW = "androidx.camera:camera-view:1.0.0-alpha02"
const val CAMERAX_EXTENSIONS = "androidx.camera:camera-extensions:1.0.0-alpha02"
const val CAMERAX_EXTENSIONS_STUB = "androidx.camera:camera-extensions-stub:1.0.0-alpha02"

const val ANDROID_ANNOTATION = "androidx.annotation:annotation:1.0.0"

const val JUNIT = "junit:junit:4.13-beta-1"
const val TRUTH = "com.google.truth:truth:0.42"
const val MOCKITO_KOTLIN = "com.nhaarman:mockito-kotlin-kt1.1:1.5.0"
const val TEST_RUNNER = "androidx.test:runner:1.1.1"
const val TEST_RULE = "androidx.test:rules:1.1.0"
const val ESPRESSO = "androidx.test.espresso:espresso-core:3.1.1"
