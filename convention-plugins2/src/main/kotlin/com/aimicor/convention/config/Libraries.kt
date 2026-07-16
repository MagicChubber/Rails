package com.aimicor.convention.config

import com.aimicor.convention.extension.TypeLibrary

enum class Libraries(override val key: String): TypeLibrary {
    KOTLIN_TEST("kotlin-test"),
    KOTLIN_COROUTINES_TEST("kotlinx-coroutines-test"),
    TURBINE("turbine"),
    PREVIEW_DESKTOP("ui-tooling-preview-desktop"),
    PREVIEW("ui-tooling-preview"),
    COMPOSE_RUNTIME("compose-runtime"),
    COMPOSE_FOUNDATION("compose-foundation"),
    COMPOSE_MATERIAL3("compose-material3"),
    COMPOSE_UI("compose-ui"),
    COMPOSE_COMPONENTS_RESOURCES("compose-components-resources"),
    COMPOSE_UI_TOOLING_PREVIEW("compose-uiToolingPreview"),
    ANDROIDX_ACTIVITY_COMPOSE("androidx-activity-compose"),
    ANDROIDX_LIFECYCLE_VIEWMODEL_COMPOSE("androidx-lifecycle-viewmodelCompose"),
    ANDROIDX_LIFECYCLE_RUNTIME_COMPOSE("androidx-lifecycle-runtimeCompose"),
    KOTLINX_COROUTINES_SWING("kotlinx-coroutinesSwing"),
    KOIN_COMPOSE("koin-compose"),
    KOIN_ANDROID("koin-android"),
    COMPOSE_UI_TOOLING("compose-uiTooling"),
}