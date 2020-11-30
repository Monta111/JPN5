package com.monta.learnjpn5.data.datasource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kanji")
data class KanjiEntity(
    @PrimaryKey var id: Int,
    var hira: String,
    var kanji: String,
    var vn: String
)