package com.monta.learnjpn5.data.datasource.remote.dto

import com.google.gson.annotations.SerializedName

data class WordDto(
    var id: Int = 0,
    @SerializedName("wordVN") var wordVN: String,
    @SerializedName("wordTQ") var wordTQ: String,
    @SerializedName("wordKanji") var wordKanji: String,
    @SerializedName("lesson") var lesson: String,
    @SerializedName("word") var word: String,
    @SerializedName("wordRomanji") var wordRomanji: String,
    var isFavorite: Boolean = false
)