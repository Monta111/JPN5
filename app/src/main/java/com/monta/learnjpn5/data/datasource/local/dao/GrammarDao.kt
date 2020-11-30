package com.monta.learnjpn5.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.monta.learnjpn5.data.datasource.local.entity.GrammarEntity

@Dao
interface GrammarDao {
    @Query("SELECT * FROM grammar WHERE lesson=:lesson")
    suspend fun getGrammars(lesson: String): List<GrammarEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGrammars(entities: List<GrammarEntity>)
}