package com.monta.learnjpn5.data.datasource.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.monta.learnjpn5.data.datasource.local.dao.AlphabetDao
import com.monta.learnjpn5.data.datasource.local.dao.GrammarDao
import com.monta.learnjpn5.data.datasource.local.dao.KanjiDao
import com.monta.learnjpn5.data.datasource.local.dao.WordDao
import com.monta.learnjpn5.data.datasource.local.entity.CharacterEntity
import com.monta.learnjpn5.data.datasource.local.entity.GrammarEntity
import com.monta.learnjpn5.data.datasource.local.entity.KanjiEntity
import com.monta.learnjpn5.data.datasource.local.entity.WordEntity

@Database(
    entities = [CharacterEntity::class, GrammarEntity::class, KanjiEntity::class, WordEntity::class],
    version = 1,
    exportSchema = false
)
abstract class N5Database : RoomDatabase() {

    abstract fun alphabetDao(): AlphabetDao
    abstract fun grammarDao(): GrammarDao
    abstract fun kanjiDao(): KanjiDao
    abstract fun wordDao(): WordDao

    companion object {

        @Volatile
        private var INSTANCE: N5Database? = null

        fun getInstance(context: Context): N5Database = INSTANCE ?: synchronized(this) {
            Room.databaseBuilder(
                context.applicationContext,
                N5Database::class.java,
                "n5"
            ).build().apply {
                INSTANCE = this
            }
        }
    }
}