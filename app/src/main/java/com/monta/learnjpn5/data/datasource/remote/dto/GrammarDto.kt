package com.monta.learnjpn5.data.datasource.remote.dto

import com.google.gson.annotations.SerializedName

data class GrammarDto(
    @SerializedName("lesson") var lesson: String,
    @SerializedName("content") var content: String
)