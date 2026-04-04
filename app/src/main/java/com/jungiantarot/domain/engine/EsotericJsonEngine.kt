package com.jungiantarot.domain.engine

import com.jungiantarot.domain.model.*
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.random.Random

class EsotericJsonEngine {

    private val colores = listOf("Púrpura", "Dorado", "Azul Noche", "Plata", "Verde Esmeralda", "Rojo Carmesí", "Blanco Perlado", "Negro Ónice")
    
    private val mensajesGenerales = listOf(
        "Hoy el cosmos te invita a la introspección. Una energía sutil pero transformadora te envuelve.",
        "La alineación astral favorece la toma de decisiones audaces. Confía en tu intuición primaria.",
        "Un día para soltar cargas innecesarias. El universo limpia tu camino para nuevos comienzos.",
        "La sincronicidad estará muy presente hoy. Presta atención a los pequeños mensajes a tu alrededor."
    )

    private val amorTextos = listOf(
        "Las barreras emocionales se disuelven. Buen momento para conversaciones vulnerables.",
        "Atracción magnética inusual. Tu magnetismo personal está en su punto máximo hoy.",
        "Es necesario poner límites sanos. Protege tu energía vital de vampiros emocionales.",
        "El equilibrio entre dar y recibir requiere tu atención. No te vacíes por otros."
    )

    private val dineroTextos = listOf(
        "Una puerta inesperada se abre. Mantente atento a oportunidades discretas.",
        "Prudencia financiera es la clave. Evita gastos impulsivos impulsados por la emoción.",
        "El trabajo duro comienza a materializarse. Un reconocimiento o avance está cerca.",
        "Reestructura tus prioridades. Invierte en conocimiento o en tu propia paz mental."
    )

    private val saludTextos = listOf(
        "Tu cuerpo pide descanso. No ignores las señales de fatiga acumulada.",
        "Vitalidad renovada. Excelente día para iniciar una nueva rutina física o espiritual.",
        "Enfócate en la hidratación y la respiración consciente para calmar el sistema nervioso.",
        "Canaliza el estrés a través del movimiento físico o la expresión creativa."
    )

    fun generateHoroscope(signo: String): HoroscopeData {
        val dateFormat = SimpleDateFormat("dd 'de' MMMM, yyyy", Locale("es", "ES"))
        val currentDate = dateFormat.format(Date())

        return HoroscopeData(
            signo = signo,
            fecha = currentDate,
            mensaje_general = mensajesGenerales.random(),
            amor = amorTextos.random(),
            dinero_trabajo = dineroTextos.random(),
            salud = saludTextos.random(),
            numero_suerte = Random.nextInt(1, 100),
            color_suerte = colores.random()
        )
    }

    fun generateTarotReading(isThreeCards: Boolean, cards: List<TarotCard>): TarotReadingData {
        val cartasSeleccionadas = mutableListOf<TarotCardPosition>()
        
        if (isThreeCards && cards.size >= 3) {
            cartasSeleccionadas.add(TarotCardPosition("Pasado", cards[0].name, cards[0].lightMeaning))
            cartasSeleccionadas.add(TarotCardPosition("Presente", cards[1].name, cards[1].shadowMeaning))
            cartasSeleccionadas.add(TarotCardPosition("Futuro", cards[2].name, cards[2].lightMeaning))
        } else if (cards.isNotEmpty()) {
            cartasSeleccionadas.add(TarotCardPosition("Carta del Día", cards[0].name, cards[0].lightMeaning))
        }

        val consejo = if (isThreeCards) {
            "Integra las lecciones del pasado para no repetir patrones, abraza el presente con consciencia y el futuro se alineará con tu verdadero propósito."
        } else {
            "Permite que esta energía te acompañe durante el día, observando cómo se manifiesta en tus interacciones."
        }

        return TarotReadingData(
            tipo_tirada = if (isThreeCards) "Pasado, Presente, Futuro de 3 cartas" else "Diaria de 1 carta",
            cartas = cartasSeleccionadas,
            consejo_final = consejo
        )
    }

    fun calculateAstrologyChart(fecha: String, hora: String, lugar: String): AstrologyChartData {
        val signs = listOf("Aries", "Tauro", "Géminis", "Cáncer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis")

        // Very basic mock calculation based on input length/hash for MVP
        // In a real app this would use an ephemeris API
        val inputString = "$fecha-$hora-$lugar".lowercase()
        val hash = inputString.hashCode()

        // Simple sun sign calculation from DD/MM/AAAA if possible
        var sunSignIndex = 0
        try {
            val parts = fecha.split("/")
            if (parts.size >= 2) {
                val day = parts[0].toIntOrNull() ?: 1
                val month = parts[1].toIntOrNull() ?: 1

                sunSignIndex = when (month) {
                    1 -> if (day <= 19) 9 else 10 // Cap/Aqu
                    2 -> if (day <= 18) 10 else 11 // Aqu/Pis
                    3 -> if (day <= 20) 11 else 0  // Pis/Ari
                    4 -> if (day <= 19) 0 else 1   // Ari/Tau
                    5 -> if (day <= 20) 1 else 2   // Tau/Gem
                    6 -> if (day <= 20) 2 else 3   // Gem/Can
                    7 -> if (day <= 22) 3 else 4   // Can/Leo
                    8 -> if (day <= 22) 4 else 5   // Leo/Vir
                    9 -> if (day <= 22) 5 else 6   // Vir/Lib
                    10 -> if (day <= 22) 6 else 7  // Lib/Sco
                    11 -> if (day <= 21) 7 else 8  // Sco/Sag
                    12 -> if (day <= 21) 8 else 9  // Sag/Cap
                    else -> kotlin.math.abs(hash) % 12
                }
            } else {
                sunSignIndex = kotlin.math.abs(hash) % 12
            }
        } catch (e: Exception) {
            sunSignIndex = kotlin.math.abs(hash) % 12
        }

        val sol = signs[sunSignIndex]
        val luna = signs[(kotlin.math.abs(hash) / 12) % 12]
        val ascendente = signs[(kotlin.math.abs(hash) / 144) % 12]

        return AstrologyChartData(
            sol = AstrologyAspect(signo = sol, descripcion = "Tu núcleo vital, tu ego y el fuego que impulsa tu proceso de individuación."),
            luna = AstrologyAspect(signo = luna, descripcion = "Tus necesidades emocionales profundas, el refugio inconsciente y tu intuición."),
            ascendente = AstrologyAspect(signo = ascendente, descripcion = "La máscara social que utilizas, tu forma de iniciar proyectos y defenderte."),
            resumen = "Una lectura de las estrellas basada en tu nacimiento en $lugar: Tu esencia ($sol) busca expresarse, pero debe nutrir tus emociones ocultas ($luna) mientras navega el mundo exterior con la armadura de ($ascendente)."
        )
    }

    fun generateAstrologyChart(sol: String, luna: String, ascendente: String): AstrologyChartData {
        return AstrologyChartData(
            sol = AstrologyAspect(signo = sol, descripcion = "Tu núcleo vital, tu ego y el fuego que impulsa tu proceso de individuación."),
            luna = AstrologyAspect(signo = luna, descripcion = "Tus necesidades emocionales profundas, el refugio inconsciente y tu intuición."),
            ascendente = AstrologyAspect(signo = ascendente, descripcion = "La máscara social que utilizas, tu forma de iniciar proyectos y defenderte."),
            resumen = "Una lectura rápida: Tu esencia ($sol) busca expresarse, pero debe nutrir tus emociones ocultas ($luna) mientras navega el mundo exterior con la armadura de ($ascendente)."
        )
    }
}