package com.monta.learnjpn5.data.datasource.remote

import com.monta.learnjpn5.data.datasource.WordDataSource
import com.monta.learnjpn5.data.datasource.remote.retrofit.Api
import com.monta.learnjpn5.data.mapper.toPOJO
import com.monta.learnjpn5.model.Word
import javax.inject.Inject

class WordRemoteDataSource @Inject constructor(private val api: Api) : WordDataSource.Remote {

    override suspend fun getWords(): List<Word> =
        api.getWords().map {
            it.toPOJO()
        }
}