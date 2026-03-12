package com.jungiantarot.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jungiantarot.domain.model.SpreadType

@Entity(tableName = "readings")
data class ReadingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val timestamp: Long,
    val spreadType: String, // String representation of SpreadType
    val cardIdsStr: String, // Comma separated IDs of drawn cards
    val userNotes: String
)