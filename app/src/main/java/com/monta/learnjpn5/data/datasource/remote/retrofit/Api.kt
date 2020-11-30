package com.monta.learnjpn5.data.datasource.remote.retrofit

import com.monta.learnjpn5.data.datasource.remote.dto.CharacterDto
import com.monta.learnjpn5.data.datasource.remote.dto.GrammarDto
import com.monta.learnjpn5.data.datasource.remote.dto.KanjiDto
import com.monta.learnjpn5.data.datasource.remote.dto.WordDto
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/alphabet")
    suspend fun getAlphabet(@Query("type") type: String): List<CharacterDto>

    @GET("/words")
    suspend fun getWords(): List<WordDto>

    @GET("/grammar")
    suspend fun getGrammars(): List<GrammarDto>

    @GET("/kanji")
    suspend fun getKanjis(): List<KanjiDto>
}