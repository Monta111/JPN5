package com.monta.learnjpn5.data.datasource.local.dao

import androidx.room.*
import com.monta.learnjpn5.data.datasource.local.entity.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("SELECT * FROM words WHERE lesson = :lesson")
    fun getWords(lesson: String): Flow<List<WordEntity>>

    @Query("SELECT * FROM words WHERE isFavorite=1")
    fun getFavoriteWords(): Flow<List<WordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWords(entities: List<WordEntity>)

    @Update
    suspend fun updateFavoriteWord(entity: WordEntity)

    @Query("SELECT * FROM words ORDER BY RANDOM() LIMIT :limit")
    suspend fun getRandomWords(limit: Int): List<WordEntity>
}