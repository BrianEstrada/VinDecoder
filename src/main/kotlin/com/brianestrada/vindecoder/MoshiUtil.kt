package com.brianestrada.vindecoder

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okio.BufferedSource
import okio.Okio

object MoshiUtil {
    private val moshi: Moshi
        get() = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

    private fun getFileAsBufferedSource(fileName: String): BufferedSource {
        val fileStream = this::class.java.getResource(fileName).openStream()
        val fileSource = Okio.source(fileStream)
        return Okio.buffer(fileSource)
    }

    private fun getMapAdapter(): JsonAdapter<Map<String, String>> {
        val type = Types.newParameterizedType(Map::class.java, String::class.java, String::class.java)
        return moshi.adapter(type)
    }

    fun deserializeMap(fileName: String): Map<String, String> {
        val bufferedSource = getFileAsBufferedSource(fileName)
        return getMapAdapter().fromJson(bufferedSource) ?: mapOf()
    }
}