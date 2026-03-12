package com.jungiantarot.domain.model

// 1. Horóscopo Diario
data class HoroscopeData(
    val signo: String,
    val fecha: String,
    val mensaje_general: String,
    val amor: String,
    val dinero_trabajo: String,
    val salud: String,
    val numero_suerte: Int,
    val color_suerte: String
)

// 2. Lectura de Tarot
data class TarotReadingData(
    val tipo_tirada: String,
    val cartas: List<TarotCardPosition>,
    val consejo_final: String
)

data class TarotCardPosition(
    val posicion: String,
    val nombre_carta: String,
    val significado: String
)

// 3. Carta Astral Básica
data class AstrologyChartData(
    val sol: AstrologyAspect,
    val luna: AstrologyAspect,
    val ascendente: AstrologyAspect,
    val resumen: String
)

data class AstrologyAspect(
    val signo: String,
    val descripcion: String
)