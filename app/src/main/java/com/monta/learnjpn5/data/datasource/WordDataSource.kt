package com.monta.learnjpn5.data.datasource

import com.monta.learnjpn5.model.Word
import kotlinx.coroutines.flow.Flow

interface WordDataSource {

    interface Local {
        fun getWords(lesson: String): Flow<List<Word>>

        fun getFavoriteWords(): Flow<List<Word>>

        suspend fun insertWords(entities: List<Word>)

        suspend fun updateFavoriteWord(word: Word)

        suspend fun getRandomWords(limit: Int): List<Word>
    }

    interface Remote {
        suspend fun getWords(): List<Word>
    }
}