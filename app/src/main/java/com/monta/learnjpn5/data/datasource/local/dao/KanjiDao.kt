package com.monta.learnjpn5.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.monta.learnjpn5.data.datasource.local.entity.KanjiEntity

@Dao
interface KanjiDao {
    @Query("SELECT * FROM kanji")
    suspend fun getKanjis(): List<KanjiEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKanjis(entities: List<KanjiEntity>)

    @Query("SELECT * FROM kanji ORDER BY RANDOM() LIMIT :limit")
    suspend fun getRandomKanjis(limit: Int): List<KanjiEntity>
}