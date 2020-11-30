package com.monta.learnjpn5.di.module

import android.content.Context
import com.monta.learnjpn5.data.AlphabetRepository
import com.monta.learnjpn5.data.GrammarRepository
import com.monta.learnjpn5.data.KanjiRepository
import com.monta.learnjpn5.data.WordRepository
import com.monta.learnjpn5.data.datasource.AlphabetDataSource
import com.monta.learnjpn5.data.datasource.GrammarDataSource
import com.monta.learnjpn5.data.datasource.KanjiDataSource
import com.monta.learnjpn5.data.datasource.WordDataSource
import com.monta.learnjpn5.data.datasource.local.AlphabetLocalDataSource
import com.monta.learnjpn5.data.datasource.local.GrammarLocalDataSource
import com.monta.learnjpn5.data.datasource.local.KanjiLocalDataSource
import com.monta.learnjpn5.data.datasource.local.WordLocalDataSource
import com.monta.learnjpn5.data.datasource.local.dao.AlphabetDao
import com.monta.learnjpn5.data.datasource.local.dao.GrammarDao
import com.monta.learnjpn5.data.datasource.local.dao.KanjiDao
import com.monta.learnjpn5.data.datasource.local.dao.WordDao
import com.monta.learnjpn5.data.datasource.local.database.N5Database
import com.monta.learnjpn5.data.datasource.remote.AlphabetRemoteDataSource
import com.monta.learnjpn5.data.datasource.remote.GrammarRemoteDataSource
import com.monta.learnjpn5.data.datasource.remote.KanjiRemoteDataSource
import com.monta.learnjpn5.data.datasource.remote.WordRemoteDataSource
import com.monta.learnjpn5.data.datasource.remote.retrofit.Api
import com.monta.learnjpn5.data.datasource.remote.retrofit.ApiRetrofit
import com.monta.learnjpn5.data.repository.DefaultAlphabetRepository
import com.monta.learnjpn5.data.repository.DefaultGrammarRepository
import com.monta.learnjpn5.data.repository.DefaultKanjiRepository
import com.monta.learnjpn5.data.repository.DefaultWordRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {
    @Singleton
    @Provides
    fun alphabetRepository(impl: DefaultAlphabetRepository): AlphabetRepository = impl

    @Singleton
    @Provides
    fun wordRepository(impl: DefaultWordRepository): WordRepository = impl

    @Singleton
    @Provides
    fun grammarRepository(impl: DefaultGrammarRepository): GrammarRepository = impl

    @Singleton
    @Provides
    fun kanjiRepository(impl: DefaultKanjiRepository): KanjiRepository = impl

    @Singleton
    @Provides
    fun alphabetLocalDataSource(impl: AlphabetLocalDataSource): AlphabetDataSource.Local = impl

    @Singleton
    @Provides
    fun alphabetRemoteDataSource(impl: AlphabetRemoteDataSource): AlphabetDataSource.Remote = impl

    @Singleton
    @Provides
    fun wordLocalDataSource(impl: WordLocalDataSource): WordDataSource.Local = impl

    @Singleton
    @Provides
    fun wordRemoteDataSource(impl: WordRemoteDataSource): WordDataSource.Remote = impl

    @Singleton
    @Provides
    fun grammarLocalDataSource(impl: GrammarLocalDataSource): GrammarDataSource.Local = impl

    @Singleton
    @Provides
    fun grammarRemoteDataSource(impl: GrammarRemoteDataSource): GrammarDataSource.Remote = impl

    @Singleton
    @Provides
    fun kanjiLocalDataSource(impl: KanjiLocalDataSource): KanjiDataSource.Local = impl

    @Singleton
    @Provides
    fun kanjiRemoteDataSource(impl: KanjiRemoteDataSource): KanjiDataSource.Remote = impl

    @Singleton
    @Provides
    fun database(context: Context): N5Database = N5Database.getInstance(context)

    @Singleton
    @Provides
    fun alphabetDao(database: N5Database): AlphabetDao = database.alphabetDao()

    @Singleton
    @Provides
    fun wordDao(database: N5Database): WordDao = database.wordDao()

    @Singleton
    @Provides
    fun grammarDao(database: N5Database): GrammarDao = database.grammarDao()

    @Singleton
    @Provides
    fun kanjiDao(database: N5Database): KanjiDao = database.kanjiDao()

    @Singleton
    @Provides
    fun api(): Api = ApiRetrofit.INSTANCE
}