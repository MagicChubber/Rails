package com.aimicor.convention.extension

import org.gradle.api.Project

/**
 * Derives a unique Maven group for this module by appending its parent project path to [baseGroup].
 *
 * Gradle identifies modules by `group:name`, and several projects here share a leaf name
 * (`state`, `ui`, `entity`, `usecase`, `repository`, `data`). Giving them all the same flat group
 * makes those projects indistinguishable during resolution, so a dependency between two of them
 * collapses into a self-dependency and the task graph becomes circular. Qualifying the group with
 * the path keeps every module's coordinates distinct.
 */
fun Project.moduleGroup(baseGroup: String): String {
    val parentPath = path.split(":").drop(1).dropLast(1).joinToString(".") { it.lowercase() }
    return if (parentPath.isEmpty()) baseGroup else "$baseGroup.$parentPath"
}
