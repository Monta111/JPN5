package com.monta.learnjpn5.data.datasource

import com.monta.learnjpn5.model.Grammar

interface GrammarDataSource {

    interface Local {
        suspend fun getGrammars(lesson: String): List<Grammar>

        suspend fun insertGrammars(entities: List<Grammar>)
    }

    interface Remote {
        suspend fun getGrammars(): List<Grammar>
    }
}