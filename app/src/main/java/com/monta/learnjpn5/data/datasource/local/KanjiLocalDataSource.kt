package com.monta.learnjpn5.data.datasource.local

import com.monta.learnjpn5.data.datasource.KanjiDataSource
import com.monta.learnjpn5.data.datasource.local.dao.KanjiDao
import com.monta.learnjpn5.data.mapper.toEntity
import com.monta.learnjpn5.data.mapper.toPOJO
import com.monta.learnjpn5.model.Kanji
import javax.inject.Inject

class KanjiLocalDataSource @Inject constructor(private val kanjiDao: KanjiDao) :
    KanjiDataSource.Local {

    override suspend fun getKanjis(): List<Kanji> =
        kanjiDao.getKanjis().map {
            it.toPOJO()
        }

    override suspend fun insertKanjis(entities: List<Kanji>) =
        kanjiDao.insertKanjis(entities.map {
            it.toEntity()
        })

    override suspend fun getRandomKanjis(limit: Int): List<Kanji> =
        kanjiDao.getRandomKanjis(limit).map {
            it.toPOJO()
        }
}