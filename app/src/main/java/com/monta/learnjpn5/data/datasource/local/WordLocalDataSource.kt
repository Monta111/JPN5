package com.monta.learnjpn5.data.datasource.local

import com.monta.learnjpn5.data.datasource.WordDataSource
import com.monta.learnjpn5.data.datasource.local.dao.WordDao
import com.monta.learnjpn5.data.mapper.toEntity
import com.monta.learnjpn5.data.mapper.toPOJO
import com.monta.learnjpn5.model.Word
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WordLocalDataSource @Inject constructor(private val wordDao: WordDao) : WordDataSource.Local {

    override fun getWords(lesson: String): Flow<List<Word>> =
        wordDao.getWords(lesson).map {
            it.map { entity ->
                entity.toPOJO()
            }
        }

    override fun getFavoriteWords(): Flow<List<Word>> =
        wordDao.getFavoriteWords().map {
            it.map { entity ->
                entity.toPOJO()
            }
        }

    override suspend fun insertWords(entities: List<Word>) =
        wordDao.insertWords(entities.map {
            it.toEntity()
        })

    override suspend fun updateFavoriteWord(word: Word) =
        wordDao.updateFavoriteWord(word.toEntity())

    override suspend fun getRandomWords(limit: Int): List<Word> =
        wordDao.getRandomWords(limit).map {
            it.toPOJO()
        }
}