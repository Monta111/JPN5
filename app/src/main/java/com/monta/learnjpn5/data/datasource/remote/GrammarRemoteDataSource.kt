package com.monta.learnjpn5.data.datasource.remote

import com.monta.learnjpn5.data.datasource.GrammarDataSource
import com.monta.learnjpn5.data.datasource.remote.retrofit.Api
import com.monta.learnjpn5.data.mapper.toPOJO
import com.monta.learnjpn5.model.Grammar
import javax.inject.Inject

class GrammarRemoteDataSource @Inject constructor(private val api: Api) : GrammarDataSource.Remote {

    override suspend fun getGrammars(): List<Grammar> =
        api.getGrammars().map {
            it.toPOJO()
        }
}