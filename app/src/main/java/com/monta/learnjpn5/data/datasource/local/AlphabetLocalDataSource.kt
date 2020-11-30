package com.monta.learnjpn5.data.datasource.local

import com.monta.learnjpn5.data.datasource.AlphabetDataSource
import com.monta.learnjpn5.data.datasource.local.dao.AlphabetDao
import com.monta.learnjpn5.data.mapper.toEntity
import com.monta.learnjpn5.data.mapper.toPOJO
import com.monta.learnjpn5.model.Character
import javax.inject.Inject

class AlphabetLocalDataSource @Inject constructor(private val alphabetDao: AlphabetDao) :
    AlphabetDataSource.Local {

    override suspend fun getAlphabet(type: String): List<Character> =
        alphabetDao.getAlphabet(type).map {
            it.toPOJO()
        }


    override suspend fun insertCharacters(entities: List<Character>) =
        alphabetDao.insertCharacters(entities.map {
            it.toEntity()
        })

}