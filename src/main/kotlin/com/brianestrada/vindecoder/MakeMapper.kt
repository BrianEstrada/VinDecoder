package com.brianestrada.vindecoder

object MakeMapper {
    private val makeCodeMap = MoshiUtil.deserializeMap("/make_map.json")
    fun getMake(code: String) = makeCodeMap[code]
}