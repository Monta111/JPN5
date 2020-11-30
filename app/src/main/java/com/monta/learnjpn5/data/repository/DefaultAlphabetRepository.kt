package com.monta.learnjpn5.data.repository

import com.monta.learnjpn5.data.AlphabetRepository
import com.monta.learnjpn5.data.datasource.AlphabetDataSource
import com.monta.learnjpn5.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultAlphabetRepository @Inject constructor(
    private val alphabetLocalDataSource: AlphabetDataSource.Local,
    private val alphabetRemoteDataSource: AlphabetDataSource.Remote
) : AlphabetRepository {

    override suspend fun getAlphabet(type: String): List<Character> =
        withContext(Dispatchers.IO) {
            val localData = alphabetLocalDataSource.getAlphabet(type)
            if (localData.isEmpty()) {
                val remoteData = alphabetRemoteDataSource.getAlphabet(type)
                alphabetLocalDataSource.insertCharacters(remoteData)
                return@withContext remoteData
            }
            return@withContext localData
        }
}