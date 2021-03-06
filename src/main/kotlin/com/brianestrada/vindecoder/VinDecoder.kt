package com.brianestrada.vindecoder

class VinDecoder(vin: String) {

    init {
        if (vin.length != 17) {
            throw RuntimeException("Invalid vin length ${vin.length}")
        }
    }

    private val vinCountryString: String = vin.substring(0, 2)
    private val vinMakerString: String = vin.substring(0, 3)

    fun getCountry(): String? {
        return CountryMapper.getCountry(vinCountryString)
    }

    fun getMake(): String? {
        return MakeMapper.getMake(vinMakerString)
    }
}
