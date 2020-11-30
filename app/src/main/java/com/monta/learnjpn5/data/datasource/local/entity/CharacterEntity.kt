package com.monta.learnjpn5.data.datasource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alphabet")
data class CharacterEntity(
    var character: String,
    var type: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
) {
    companion object
}