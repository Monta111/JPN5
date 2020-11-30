package com.monta.learnjpn5.data.datasource.remote.dto

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    var id: Int = 0,
    @SerializedName("character") var character: String,
    @SerializedName("type") var type: String
)