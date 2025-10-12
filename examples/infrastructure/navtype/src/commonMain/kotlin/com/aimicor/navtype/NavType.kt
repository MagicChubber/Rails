package com.aimicor.navtype

import androidx.navigation.NavType
import androidx.savedstate.SavedState
import androidx.savedstate.read
import androidx.savedstate.write
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.thauvin.erik.urlencoder.UrlEncoderUtil
import kotlin.reflect.typeOf

inline fun <reified T : Any> serializableType(
    isNullableAllowed: Boolean = false,
    json: Json = Json,
) = object : NavType<T>(isNullableAllowed = isNullableAllowed) {

    override fun get(bundle: SavedState, key: String): T? =
        bundle.read { getStringOrNull(key)?.let { parseValue(it) } }

    override fun serializeAsValue(value: T): String =
        UrlEncoderUtil.encode(json.encodeToString(value))

    override fun parseValue(value: String): T =
        json.decodeFromString<T>(UrlEncoderUtil.decode(value))

    override fun put(bundle: SavedState, key: String, value: T) {
        bundle.write { putString(key, serializeAsValue(value)) }
    }
}

inline fun <reified T : Any> typePair() = typeOf<T>() to serializableType<T>()
