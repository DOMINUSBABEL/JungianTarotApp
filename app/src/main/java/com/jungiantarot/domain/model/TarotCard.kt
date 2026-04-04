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
        id = 3,
        name = "La Emperatriz",
        archetype = "El Ánima / La Madre Naturaleza",
        lightMeaning = "Creatividad, fertilidad, abundancia, nutrición. El florecimiento de la vida y los sentidos.",
        shadowMeaning = "Estancamiento, dependencia, asfixia creativa o emocional. ¿Qué estás descuidando o sofocando?",
        imageUrl = "https://example.com/emperatriz.png"
    ),
    TarotCard(
        id = 4,
        name = "El Emperador",
        archetype = "El Padre / El Líder",
        lightMeaning = "Estructura, autoridad, protección, orden racional. El establecimiento de límites necesarios.",
        shadowMeaning = "Tiranía, rigidez, abuso de poder, falta de flexibilidad. ¿Dónde estás siendo demasiado dominante o inflexible?",
        imageUrl = "https://example.com/emperador.png"
    ),
    TarotCard(
        id = 5,
        name = "El Hierofante",
        archetype = "El Maestro / El Guía",
        lightMeaning = "Tradición, sabiduría espiritual, educación, conformidad con lo sagrado.",
        shadowMeaning = "Dogmatismo, hipocresía, conformidad ciega a reglas obsoletas. ¿Qué creencias ya no resuenan con tu verdad?",
        imageUrl = "https://example.com/hierofante.png"
    ),
    TarotCard(
        id = 6,
        name = "Los Enamorados",
        archetype = "La Unión de Opuestos / Sizigia",
        lightMeaning = "Elección, armonía, alineación de valores, integración de dualidades.",
        shadowMeaning = "Desequilibrio, indecisión, conflicto interno, valores contradictorios. ¿Qué partes de ti necesitan reconciliarse?",
        imageUrl = "https://example.com/enamorados.png"
    ),
    TarotCard(
        id = 7,
        name = "El Carro",
        archetype = "El Héroe",
        lightMeaning = "Victoria, determinación, control del ego, avance decidido hacia una meta.",
        shadowMeaning = "Agresión, falta de dirección, arrogancia, pérdida de control sobre los impulsos. ¿Estás dirigiendo tu vida o dejándote llevar?",
        imageUrl = "https://example.com/carro.png"
    ),
    TarotCard(
        id = 8,
        name = "La Justicia",
        archetype = "El Equilibrio / La Ley",
        lightMeaning = "Verdad, integridad, causa y efecto, justicia imparcial.",
        shadowMeaning = "Injusticia, falta de responsabilidad, juicios severos o prejuiciados. ¿De qué verdad estás tratando de escapar?",
        imageUrl = "https://example.com/justicia.png"
    ),
    TarotCard(
        id = 9,
        name = "El Ermitaño",
        archetype = "El Viejo Sabio",
        lightMeaning = "Introspección, soledad buscada, iluminación interior, guía silenciosa.",
        shadowMeaning = "Aislamiento, amargura, rechazo a la ayuda, soledad no deseada. ¿Tienes miedo de encontrarte contigo mismo en el silencio?",
        imageUrl = "https://example.com/ermitano.png"
    ),
    TarotCard(
        id = 10,
        name = "La Rueda de la Fortuna",
        archetype = "El Destino / Sincronicidad",
        lightMeaning = "Cambio inevitable, ciclos, nuevas oportunidades, comprensión de los giros de la vida.",
        shadowMeaning = "Resistencia al cambio, mala suerte percibida, sensación de descontrol. ¿Cómo te relacionas con lo inesperado?",
        imageUrl = "https://example.com/rueda.png"
    ),
    TarotCard(
        id = 11,
        name = "La Fuerza",
        archetype = "La Fuerza Interior",
        lightMeaning = "Coraje, compasión, domar los instintos primarios con amor y voluntad.",
        shadowMeaning = "Debilidad, impulsividad, uso de la fuerza bruta, falta de autocontrol. ¿Qué instinto estás reprimiendo o permitiendo que te domine?",
        imageUrl = "https://example.com/fuerza.png"
    ),
    TarotCard(
        id = 12,
        name = "El Colgado",
        archetype = "El Sacrificio / Nueva Perspectiva",
        lightMeaning = "Pausa necesaria, dejar ir, ver el mundo desde un ángulo diferente, rendición consciente.",
        shadowMeaning = "Indecisión, estancamiento, martirio innecesario, resistencia al sacrificio. ¿A qué te aferras que ya no te sirve?",
        imageUrl = "https://example.com/colgado.png"
    ),
    TarotCard(
        id = 13,
        name = "La Muerte",
        archetype = "La Transformación",
        lightMeaning = "Final de un ciclo, renovación, soltar lo viejo para permitir lo nuevo, cambio profundo.",
        shadowMeaning = "Miedo al cambio, resistencia a lo inevitable, apego doloroso al pasado. ¿Qué parte de ti necesita morir para que puedas renacer?",
        imageUrl = "https://example.com/muerte.png"
    ),
    TarotCard(
        id = 14,
        name = "La Templanza",
        archetype = "La Alquimia / Integración",
        lightMeaning = "Equilibrio, moderación, armonía de contrarios, paciencia y propósito.",
        shadowMeaning = "Exceso, desequilibrio emocional, falta de enfoque, impaciencia. ¿Qué opuestos en tu vida necesitan ser reconciliados?",
        imageUrl = "https://example.com/templanza.png"
    ),
    TarotCard(
        id = 15,
        name = "El Diablo",
        archetype = "La Sombra",
        lightMeaning = "Reconocer las ataduras, enfrentar los miedos, abrazar la totalidad de tu ser, incluyendo tus partes oscuras.",
        shadowMeaning = "Adicciones, materialismo extremo, represión de deseos, estar dominado por impulsos inconscientes. ¿A qué estás encadenado?",
        imageUrl = "https://example.com/diablo.png"
    ),
    TarotCard(
        id = 16,
        name = "La Torre",
        archetype = "La Ruptura del Ego",
        lightMeaning = "Liberación repentina, revelación, demolición de falsas estructuras para construir sobre la verdad.",
        shadowMeaning = "Caos, desastre evitable, miedo a la caída, aferrarse a una seguridad ilusoria. ¿Qué estructura en tu vida se está derrumbando?",
        imageUrl = "https://example.com/torre.png"
    ),
    TarotCard(
        id = 17,
        name = "La Estrella",
        archetype = "La Esperanza / Renovación",
        lightMeaning = "Inspiración, serenidad, conexión con el cosmos, sanación después de la tormenta.",
        shadowMeaning = "Desesperanza, falta de fe, desconexión espiritual, pesimismo. ¿Dónde has perdido tu capacidad de confiar en el futuro?",
        imageUrl = "https://example.com/estrella.png"
    ),
    TarotCard(
        id = 18,
        name = "La Luna",
        archetype = "El Inconsciente Profundo / La Sombra",
        lightMeaning = "Imaginación, sueños, intuición profunda, navegación por las aguas del inconsciente.",
        shadowMeaning = "Confusión, engaño, miedos irracionales, ansiedad, pérdida en la ilusión. ¿Qué verdades se ocultan en tus sombras?",
        imageUrl = "https://example.com/luna.png"
    ),
    TarotCard(
        id = 19,
        name = "El Sol",
        archetype = "El Sí-mismo / Claridad",
        lightMeaning = "Éxito, vitalidad, conciencia plena, alegría expansiva, verdad revelada.",
        shadowMeaning = "Arrogancia, falta de brillo, excesiva confianza, superficialidad. ¿Estás permitiendo que tu luz brille sin cegar a otros?",
        imageUrl = "https://example.com/sol.png"
    ),
    TarotCard(
        id = 20,
        name = "El Juicio",
        archetype = "El Despertar / Vocación",
        lightMeaning = "Renacimiento, llamado interior, evaluación consciente del pasado, redención.",
        shadowMeaning = "Autocrítica excesiva, negación del llamado, culpa paralizante, falta de autoconciencia. ¿Estás listo para responder a tu vocación?",
        imageUrl = "https://example.com/juicio.png"
    ),
    TarotCard(
        id = 21,
        name = "El Mundo",
        archetype = "La Individuación / Totalidad",
        lightMeaning = "Realización, plenitud, integración completa de la psique, el final de un viaje y el inicio de otro.",
        shadowMeaning = "Incompletitud, falta de cierre, resistencia a la culminación, visión limitada. ¿Has logrado integrar todas las partes de tu ser?",
        imageUrl = "https://example.com/mundo.png"
    )
)
