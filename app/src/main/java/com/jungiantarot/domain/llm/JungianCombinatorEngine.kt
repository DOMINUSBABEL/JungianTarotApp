package com.jungiantarot.domain.llm

import com.jungiantarot.domain.model.TarotCard

class JungianCombinatorEngine {

    // PARTE A: Contexto de la carta (10 variantes)
    private val aperturas = listOf(
        "La sincronicidad de este momento ha revelado a %s, despertando el arquetipo de %s en tu psique.",
        "A través de la bruma del inconsciente emerge %s, obligándote a confrontar la energía de %s.",
        "El mandala de tu vida actual se estructura en torno a %s, irradiando la profunda fuerza de %s.",
        "Tu ego es desafiado por la aparición de %s, un espejo del arquetipo de %s que yace latente.",
        "Has invocado a %s; el cosmos responde mostrándote la naturaleza pura de %s.",
        "En el teatro de tus sueños y tu vigilia, %s toma el centro del escenario encarnando a %s.",
        "La energía psíquica se ha concentrado en %s, exigiendo que integres a %s en tu consciencia.",
        "Un llamado desde las profundidades oscuras ha traído a %s, el mensajero de %s.",
        "La constelación de tu destino hoy vibra con %s, reflejando el poder de %s.",
        "No es casualidad que %s aparezca ahora, señalando el inminente despertar de %s."
    )

    // PARTE B: Influencia Astrológica (Sol, Luna, Ascendente) (12 variantes)
    private val influenciasAstrologicas = listOf(
        "Tu Sol en %s ilumina este proceso, exigiendo una asimilación activa y ardiente.",
        "La Luna en %s colorea esta revelación con matices emocionales profundos y receptivos.",
        "Tu Ascendente %s filtra esta energía, obligándote a replantear la máscara que muestras al mundo.",
        "El fuego de tu Sol en %s entra en tensión alquímica con este arquetipo.",
        "Las aguas de tu Luna en %s amenazan con disolver las fronteras frente a esta nueva energía.",
        "La estructura de tu Ascendente %s intenta contener en vano la erupción de este símbolo.",
        "Como portador de un Sol en %s, tu viaje de individuación se acelera radicalmente aquí.",
        "Tu Luna en %s te susurra secretos sobre este arquetipo que tu ego prefiere ignorar.",
        "El Ascendente %s es la armadura que debe caer para que este mensaje sea recibido.",
        "Tu identidad central, enraizada en tu Sol en %s, se ve sacudida hasta sus cimientos.",
        "La intuición de tu Luna en %s ya presentía la llegada de esta confrontación.",
        "Tu Ascendente %s actúa como un puente vital entre este arquetipo y tu realidad tangible."
    )

    // PARTE C: Tensión / Conflicto Jungiano (15 variantes)
    private val conflictosJungianos = listOf(
        "Esto destapa una Sombra reprimida que has estado proyectando en figuras de autoridad.",
        "Revela un complejo autónomo que secuestra tus reacciones emocionales en momentos de estrés.",
        "Exige que sostengas la tensión de los opuestos sin buscar una salida fácil o prematura.",
        "Apunta directamente a una herida infantil que tu ego ha intentado tapar con perfeccionismo.",
        "Subraya el agotamiento psíquico de sostener una Persona (máscara) que ya no te representa.",
        "Pone en evidencia el desequilibrio entre tu consciencia racional y tu intuición salvaje.",
        "Manifiesta la necesidad urgente de integrar tu Ánima/Animus para encontrar la totalidad.",
        "Indica que estás atravesando una 'noche oscura del alma' necesaria para tu evolución.",
        "Muestra cómo tus miedos irracionales están saboteando tu potencial creativo latente.",
        "Destaca una lealtad inconsciente a mandatos familiares que limitan tu verdadera vocación.",
        "Revela que la verdadera prisión no es externa, sino un constructo de tus propias creencias limitantes.",
        "Apunta a una inflación del ego que te ciega ante la sabiduría de tu propio cuerpo.",
        "Subraya la desconexión con el instinto primario debido a un exceso de intelectualización.",
        "Manifiesta un patrón de auto-sabotaje en el umbral de una transformación significativa.",
        "Indica que el miedo al rechazo te mantiene atado a un ciclo repetitivo y estéril."
    )

    // PARTE D: Cierre Alquímico / Integración (12 variantes)
    private val cierresAlquimicos = listOf(
        "¿Estás dispuesto a quemar la madera muerta de tu pasado para renacer de estas cenizas?",
        "La verdadera alquimia comienza cuando abrazas aquello que más te aterra mirar.",
        "Deja que el símbolo te habite; no intentes analizarlo, solo permítele transmutar tu dolor.",
        "El tesoro que buscas se encuentra exactamente en la cueva a la que tienes miedo entrar.",
        "Tu tarea no es curar el síntoma, sino escuchar el mensaje del alma que lo origina.",
        "Acepta la paradoja. Solo en el abrazo de la luz y la oscuridad encontrarás tu centro.",
        "Ríndete al misterio. Tu mente lógica no puede resolver un enigma diseñado para el espíritu.",
        "El oro alquímico se forja en la presión de esta incomodidad. Resiste el impulso de huir.",
        "Convierte esta herida en tu vocación; el sanador herido es el único que verdaderamente cura.",
        "Despójate de las expectativas ajenas y escucha el llamado auténtico de tu Sí-Mismo.",
        "La integración requiere paciencia feroz; permite que el proceso se despliegue a su propio ritmo.",
        "Recuerda: la flor de loto más hermosa tiene sus raíces en el lodo más oscuro."
    )

    /**
     * Genera una interpretación única combinando matrices de texto.
     * Genera más de 470,000 combinaciones diferentes sin usar memoria RAM.
     */
    fun generateInterpretation(
        card: TarotCard,
        sunSign: String,
        moonSign: String,
        ascendantSign: String
    ): String {
        // Seleccionamos aleatoriamente uno de los tres signos para variar la influencia astrológica
        val signos = listOf(sunSign, moonSign, ascendantSign)
        val signoSeleccionado = signos.random()

        val parteA = String.format(aperturas.random(), card.name, card.archetype)
        val parteB = String.format(influenciasAstrologicas.random(), signoSeleccionado)
        val parteC = conflictosJungianos.random()
        val parteD = cierresAlquimicos.random()

        return "$parteA\n$parteB\n$parteC\n$parteD"
    }
}