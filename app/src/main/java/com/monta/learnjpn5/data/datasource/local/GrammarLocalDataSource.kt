package com.monta.learnjpn5.data.datasource.local

import com.monta.learnjpn5.data.datasource.GrammarDataSource
import com.monta.learnjpn5.data.datasource.local.dao.GrammarDao
import com.monta.learnjpn5.data.mapper.toEntity
import com.monta.learnjpn5.data.mapper.toPOJO
import com.monta.learnjpn5.model.Grammar
import javax.inject.Inject

class GrammarLocalDataSource @Inject constructor(private val grammarDao: GrammarDao) :
    GrammarDataSource.Local {

    override suspend fun getGrammars(lesson: String): List<Grammar> =
        grammarDao.getGrammars(lesson).map {
            it.toPOJO()
        }

    override suspend fun insertGrammars(entities: List<Grammar>) =
        grammarDao.insertGrammars(entities.map {
            it.toEntity()
        })
}