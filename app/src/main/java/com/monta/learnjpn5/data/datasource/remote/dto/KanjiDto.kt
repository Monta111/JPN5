package com.monta.learnjpn5.data.datasource.remote.dto

import com.google.gson.annotations.SerializedName

data class KanjiDto(
    @SerializedName("hira") var hira: String,
    @SerializedName("kanji") var kanji: String,
    @SerializedName("vn") var vn: String,
    @SerializedName("id") var id: Int
)