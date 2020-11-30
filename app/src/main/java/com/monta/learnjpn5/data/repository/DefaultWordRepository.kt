package com.monta.learnjpn5.data.repository

import com.monta.learnjpn5.data.WordRepository
import com.monta.learnjpn5.data.datasource.WordDataSource
import com.monta.learnjpn5.model.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultWordRepository @Inject constructor(
    private val wordLocalDataSource: WordDataSource.Local,
    private val wordRemoteDataSource: WordDataSource.Remote
) : WordRepository {

    override fun getWords(lesson: String) = flow {
        wordLocalDataSource.getWords(lesson)
            .collect {
                if (it.isEmpty()) {
                    val remoteData = wordRemoteDataSource.getWords()
                    wordLocalDataSource.insertWords(remoteData)
                    emit(remoteData.filter { word ->
                        word.lesson == lesson
                    })
                } else
                    emit(it)
            }
    }.flowOn(Dispatchers.IO)


    override fun getFavoriteWords() =
        wordLocalDataSource.getFavoriteWords().flowOn(Dispatchers.IO)


    override suspend fun updateFavoriteWord(word: Word) =
        withContext(Dispatchers.IO) {
            wordLocalDataSource.updateFavoriteWord(word)
        }

    override suspend fun getRandomWords(limit: Int): List<Word> =
        withContext(Dispatchers.IO) {
            val localData = wordLocalDataSource.getRandomWords(limit)
            if (localData.isEmpty()) {
                val remoteData = wordRemoteDataSource.getWords()
                wordLocalDataSource.insertWords(remoteData)
                return@withContext remoteData.subList(0, limit)
            }

            return@withContext localData
        }
}