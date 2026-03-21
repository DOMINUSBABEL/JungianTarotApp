package com.jungiantarot.domain.engine

import com.jungiantarot.domain.model.AstrologyChartData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class EsotericJsonEngineTest {

    private lateinit var engine: EsotericJsonEngine

    @Before
    fun setUp() {
        engine = EsotericJsonEngine()
    }

    @Test
    fun testGenerateAstrologyChart() {
        val sol = "Leo"
        val luna = "Escorpio"
        val ascendente = "Acuario"

        val result = engine.generateAstrologyChart(sol, luna, ascendente)

        assertEquals(sol, result.sol.signo)
        assertEquals(luna, result.luna.signo)
        assertEquals(ascendente, result.ascendente.signo)

        val expectedResumen = "Una lectura rápida: Tu esencia ($sol) busca expresarse, pero debe nutrir tus emociones ocultas ($luna) mientras navega el mundo exterior con la armadura de ($ascendente)."
        assertEquals(expectedResumen, result.resumen)

        // Check descriptions are not empty
        assertTrue("Sol description should not be empty", result.sol.descripcion.isNotEmpty())
        assertTrue("Luna description should not be empty", result.luna.descripcion.isNotEmpty())
        assertTrue("Ascendente description should not be empty", result.ascendente.descripcion.isNotEmpty())
    }
}
