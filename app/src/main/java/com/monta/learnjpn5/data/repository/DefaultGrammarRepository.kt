package com.monta.learnjpn5.data.repository

import com.monta.learnjpn5.data.GrammarRepository
import com.monta.learnjpn5.data.datasource.GrammarDataSource
import com.monta.learnjpn5.model.Grammar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultGrammarRepository @Inject constructor(
    private val grammarLocalDataSource: GrammarDataSource.Local,
    private val grammarRemoteDataSource: GrammarDataSource.Remote
) : GrammarRepository {

    override suspend fun getGrammars(lesson: String): List<Grammar> =
        withContext(Dispatchers.IO) {
            val localData = grammarLocalDataSource.getGrammars(lesson)
            if (localData.isEmpty()) {
                val remoteData = grammarRemoteDataSource.getGrammars()
                grammarLocalDataSource.insertGrammars(remoteData)
                return@withContext remoteData.filter {
                    it.lesson == lesson
                }
            }
            return@withContext localData
        }
}