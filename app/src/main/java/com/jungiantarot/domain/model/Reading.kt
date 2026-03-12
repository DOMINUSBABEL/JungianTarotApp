package com.jungiantarot.domain.model

import java.time.LocalDateTime

data class Reading(
    val id: Long = 0,
    val date: LocalDateTime,
    val spreadType: SpreadType,
    val drawnCardsIds: List<Int>,
    val userNotes: String = ""
)

enum class SpreadType {
    SINGLE_CARD_DAILY, // Carta diaria de sincronicidad
    THREE_CARDS,       // Consciente, Inconsciente, Integración
    SHADOW_WORK        // Exploración de la Sombra
}