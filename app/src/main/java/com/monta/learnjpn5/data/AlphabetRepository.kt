package com.monta.learnjpn5.data

import com.monta.learnjpn5.model.Character

interface AlphabetRepository {

    suspend fun getAlphabet(type: String): List<Character>
}