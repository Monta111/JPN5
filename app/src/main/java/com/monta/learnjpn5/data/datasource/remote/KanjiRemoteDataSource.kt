package com.monta.learnjpn5.data.datasource.remote

import com.monta.learnjpn5.data.datasource.KanjiDataSource
import com.monta.learnjpn5.data.datasource.remote.retrofit.Api
import com.monta.learnjpn5.data.mapper.toPOJO
import com.monta.learnjpn5.model.Kanji
import javax.inject.Inject

class KanjiRemoteDataSource @Inject constructor(private val api: Api) : KanjiDataSource.Remote {

    override suspend fun getKanjis(): List<Kanji> =
        api.getKanjis().map {
            it.toPOJO()
        }
}