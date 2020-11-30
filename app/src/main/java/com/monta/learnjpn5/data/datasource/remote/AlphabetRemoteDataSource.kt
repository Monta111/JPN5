package com.monta.learnjpn5.data.datasource.remote

import com.monta.learnjpn5.data.datasource.AlphabetDataSource
import com.monta.learnjpn5.data.datasource.remote.retrofit.Api
import com.monta.learnjpn5.data.mapper.toPOJO
import com.monta.learnjpn5.model.Character
import javax.inject.Inject

class AlphabetRemoteDataSource @Inject constructor(private val api: Api) :
    AlphabetDataSource.Remote {

    override suspend fun getAlphabet(type: String): List<Character> =
        api.getAlphabet(type).map {
            it.toPOJO()
        }
}