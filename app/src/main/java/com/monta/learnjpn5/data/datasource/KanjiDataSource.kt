package com.monta.learnjpn5.data.datasource

import com.monta.learnjpn5.model.Kanji

interface KanjiDataSource {

    interface Local {
        suspend fun getKanjis(): List<Kanji>

        suspend fun insertKanjis(entities: List<Kanji>)

        suspend fun getRandomKanjis(limit: Int): List<Kanji>
    }

    interface Remote {
        suspend fun getKanjis(): List<Kanji>
    }
}