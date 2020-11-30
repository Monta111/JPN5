package com.monta.learnjpn5.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.monta.learnjpn5.data.datasource.local.entity.CharacterEntity

@Dao
interface AlphabetDao {
    @Query("SELECT * FROM alphabet where type=:type")
    suspend fun getAlphabet(type: String): List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(entities: List<CharacterEntity>)
}