package com.monta.learnjpn5.data

import com.monta.learnjpn5.model.Kanji

interface KanjiRepository {

    suspend fun getKanjis(): List<Kanji>

    suspend fun getRandomKanjis(limit: Int): List<Kanji>
}