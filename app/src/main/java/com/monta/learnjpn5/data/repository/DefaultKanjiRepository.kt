package com.monta.learnjpn5.data.repository

import com.monta.learnjpn5.data.KanjiRepository
import com.monta.learnjpn5.data.datasource.KanjiDataSource
import com.monta.learnjpn5.model.Kanji
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultKanjiRepository @Inject constructor(
    private val kanjiLocalDataSource: KanjiDataSource.Local,
    private val kanjiRemoteDataSource: KanjiDataSource.Remote
) : KanjiRepository {

    override suspend fun getKanjis(): List<Kanji> = withContext(Dispatchers.IO) {
        val localData = kanjiLocalDataSource.getKanjis()
        if (localData.isEmpty()) {
            val remoteData = kanjiRemoteDataSource.getKanjis()
            kanjiLocalDataSource.insertKanjis(remoteData)
            return@withContext remoteData
        }
        return@withContext localData
    }


    override suspend fun getRandomKanjis(limit: Int): List<Kanji> = withContext(Dispatchers.IO) {
        val localData = kanjiLocalDataSource.getRandomKanjis(limit)
        if (localData.isEmpty()) {
            val remoteData = kanjiRemoteDataSource.getKanjis()
            kanjiLocalDataSource.insertKanjis(remoteData)
            return@withContext remoteData.subList(0, limit)
        }

        return@withContext localData
    }
}