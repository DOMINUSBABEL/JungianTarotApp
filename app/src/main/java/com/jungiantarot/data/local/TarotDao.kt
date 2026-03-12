package com.jungiantarot.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TarotDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReading(readingEntity: ReadingEntity)

    @Query("SELECT * FROM readings ORDER BY timestamp DESC")
    fun getAllReadings(): Flow<List<ReadingEntity>>

    @Query("SELECT * FROM readings WHERE id = :readingId LIMIT 1")
    suspend fun getReadingById(readingId: Long): ReadingEntity?
}