package com.aimicor.convention.ext

import com.aimicor.convention.config.TypeVersion
import org.gradle.api.artifacts.VersionCatalog

fun VersionCatalog.versions(version: TypeVersion): String =
    findVersion(version.key).get().requiredVersion