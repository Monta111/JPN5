package com.monta.learnjpn5.data.datasource

import com.monta.learnjpn5.model.Character

interface AlphabetDataSource {

    interface Local {
        suspend fun getAlphabet(type: String): List<Character>

        suspend fun insertCharacters(entities: List<Character>)
    }

    interface Remote {
        suspend fun getAlphabet(type: String): List<Character>
    }
}