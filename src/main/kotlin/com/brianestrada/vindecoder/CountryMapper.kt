package com.brianestrada.vindecoder

object CountryMapper {
    private val countryCodeMap = MoshiUtil.deserializeMap("/country_map.json")
    fun getCountry(code: String) = countryCodeMap[code]
}