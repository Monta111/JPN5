package com.monta.learnjpn5.data

import com.monta.learnjpn5.model.Grammar

interface GrammarRepository {

    suspend fun getGrammars(lesson: String): List<Grammar>
}