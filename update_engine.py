import re

with open("app/src/main/java/com/jungiantarot/domain/engine/EsotericJsonEngine.kt", "r") as f:
    content = f.read()

new_method = """
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
"""

content = content.replace("fun generateAstrologyChart(sol: String, luna: String, ascendente: String): AstrologyChartData {", new_method.strip() + "\n\n    fun generateAstrologyChart(sol: String, luna: String, ascendente: String): AstrologyChartData {")

with open("app/src/main/java/com/jungiantarot/domain/engine/EsotericJsonEngine.kt", "w") as f:
    f.write(content)
