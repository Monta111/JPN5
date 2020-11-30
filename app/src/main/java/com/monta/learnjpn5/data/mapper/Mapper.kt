package com.monta.learnjpn5.data.mapper

import com.monta.learnjpn5.data.datasource.local.entity.CharacterEntity
import com.monta.learnjpn5.data.datasource.local.entity.GrammarEntity
import com.monta.learnjpn5.data.datasource.local.entity.KanjiEntity
import com.monta.learnjpn5.data.datasource.local.entity.WordEntity
import com.monta.learnjpn5.data.datasource.remote.dto.CharacterDto
import com.monta.learnjpn5.data.datasource.remote.dto.GrammarDto
import com.monta.learnjpn5.data.datasource.remote.dto.KanjiDto
import com.monta.learnjpn5.data.datasource.remote.dto.WordDto
import com.monta.learnjpn5.model.Character
import com.monta.learnjpn5.model.Grammar
import com.monta.learnjpn5.model.Kanji
import com.monta.learnjpn5.model.Word

fun CharacterEntity.toPOJO() = Character(character, type, id)
fun Character.toEntity() = CharacterEntity(character, type, id)
fun CharacterDto.toPOJO() = Character(character, type, id)

fun GrammarEntity.toPOJO() = Grammar(lesson, content, id)
fun Grammar.toEntity() = GrammarEntity(lesson, content, id)
fun GrammarDto.toPOJO() = Grammar(lesson, content)

fun KanjiEntity.toPOJO() = Kanji(id, hira, kanji, vn)
fun Kanji.toEntity() = KanjiEntity(id, hira, kanji, vn)
fun KanjiDto.toPOJO() = Kanji(id, hira, kanji, vn)

fun WordEntity.toPOJO() = Word(id, wordVN, word, wordRomanji, isFavorite, lesson)
fun Word.toEntity() = WordEntity(id, wordVN, word, wordRomanji, isFavorite, lesson)
fun WordDto.toPOJO() = Word(id, wordVN, word, wordRomanji, isFavorite, lesson)