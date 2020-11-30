package com.monta.learnjpn5.data.datasource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grammar")
data class GrammarEntity(
    var lesson: String,
    var content: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)