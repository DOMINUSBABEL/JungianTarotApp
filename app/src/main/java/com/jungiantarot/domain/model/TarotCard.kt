package com.jungiantarot.domain.model

data class TarotCard(
    val id: Int,
    val name: String,
    val archetype: String,
    val lightMeaning: String,
    val shadowMeaning: String,
    val imageUrl: String
)

val MajorArcana = listOf(
    TarotCard(
        id = 0,
        name = "El Loco",
        archetype = "El Niño / El Inocente",
        lightMeaning = "Nuevos comienzos, potencial infinito, espontaneidad, salto de fe. Confía en el proceso del inconsciente.",
        shadowMeaning = "Imprudencia, ignorar advertencias, evasión de la realidad. ¿De qué estás huyendo?",
        imageUrl = "https://example.com/loco.png"
    ),
    TarotCard(
        id = 1,
        name = "El Mago",
        archetype = "El Mago / El Creador",
        lightMeaning = "Manifestación, poder de la voluntad, enfoque. El ego canalizando el inconsciente.",
        shadowMeaning = "Manipulación, engaño, uso indebido del poder. ¿Qué talento estás ocultando o usando para controlar a otros?",
        imageUrl = "https://example.com/mago.png"
    ),
    TarotCard(
        id = 2,
        name = "La Suma Sacerdotisa",
        archetype = "El Ánima / La Gran Madre",
        lightMeaning = "Intuición, misterio, conexión con el inconsciente, sabiduría interior profunda.",
        shadowMeaning = "Secretos ocultos, desconexión del mundo real, negación de lo racional. ¿Qué voz interior te niegas a escuchar?",
        imageUrl = "https://example.com/sacerdotisa.png"
    ),
    TarotCard(
        id = 15,
        name = "El Diablo",
        archetype = "La Sombra",
        lightMeaning = "Reconocer las ataduras, enfrentar los miedos, abrazar la totalidad de tu ser, incluyendo tus partes oscuras.",
        shadowMeaning = "Adicciones, materialismo extremo, represión de deseos, estar dominado por impulsos inconscientes. ¿A qué estás encadenado?",
        imageUrl = "https://example.com/diablo.png"
    )
    // Más cartas pueden ser agregadas aquí...
)
