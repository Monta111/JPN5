package com.monta.learnjpn5.data.datasource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class WordEntity(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var wordVN: String,
    var word: String,
    var wordRomanji: String,
    var isFavorite: Boolean,
    var lesson: String
)