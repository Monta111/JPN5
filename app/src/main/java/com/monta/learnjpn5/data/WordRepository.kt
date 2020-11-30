package com.monta.learnjpn5.data

import com.monta.learnjpn5.model.Word
import kotlinx.coroutines.flow.Flow

interface WordRepository {

    fun getWords(lesson: String): Flow<List<Word>>

    fun getFavoriteWords(): Flow<List<Word>>

    suspend fun updateFavoriteWord(word: Word)

    suspend fun getRandomWords(limit: Int): List<Word>
}