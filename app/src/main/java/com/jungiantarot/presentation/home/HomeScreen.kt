package com.jungiantarot.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jungiantarot.domain.engine.EsotericJsonEngine
import com.jungiantarot.domain.model.HoroscopeData

@Composable
fun HomeScreen(navController: NavController) {
    val signos = listOf("Aries", "Tauro", "Géminis", "Cáncer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis")
    var selectedSign by remember { mutableStateOf(signos[0]) }
    var horoscopeData by remember { mutableStateOf<HoroscopeData?>(null) }
    val engine = remember { EsotericJsonEngine() }

    LaunchedEffect(selectedSign) {
        horoscopeData = engine.generateHoroscope(selectedSign)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)) // Oscuro minimalista
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Horóscopo Diario",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, bottom = 24.dp)
        )

        // Selector de signos minimalista
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(signos) { signo ->
                val isSelected = signo == selectedSign
                Box(
                    modifier = Modifier
                        .clickable { selectedSign = signo }
                        .background(
                            color = if (isSelected) Color(0xFF6200EA) else Color(0xFF1E1E1E), // Tono morado místico
                            shape = MaterialTheme.shapes.small
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = signo,
                        color = if (isSelected) Color.White else Color.Gray,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        horoscopeData?.let { data ->
            // Mensaje General
            Text(
                text = data.mensaje_general,
                color = Color.LightGray,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Tarjetas de predicción
            PredictionCard(title = "Amor", content = data.amor)
            PredictionCard(title = "Dinero y Trabajo", content = data.dinero_trabajo)
            PredictionCard(title = "Salud", content = data.salud)

            Spacer(modifier = Modifier.height(16.dp))

            // Suerte
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                LuckBadge(label = "Número", value = data.numero_suerte.toString())
                LuckBadge(label = "Color", value = data.color_suerte)
            }
        }
    }
}

@Composable
fun PredictionCard(title: String, content: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, color = Color(0xFFBB86FC), fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = content, color = Color.White, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}

@Composable
fun LuckBadge(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label, color = Color.Gray, fontSize = 12.sp)
        Text(text = value, color = Color(0xFF03DAC5), fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}