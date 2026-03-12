package com.jungiantarot.presentation.astrology

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jungiantarot.domain.engine.EsotericJsonEngine
import com.jungiantarot.domain.model.AstrologyChartData

@Composable
fun BirthChartScreen() {
    var fecha by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }
    var lugar by remember { mutableStateOf("") }
    
    var chartData by remember { mutableStateOf<AstrologyChartData?>(null) }
    val engine = remember { EsotericJsonEngine() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Carta Astral Básica",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, bottom = 24.dp)
        )

        if (chartData == null) {
            // Formulario Minimalista
            OutlinedTextField(
                value = fecha,
                onValueChange = { fecha = it },
                label = { Text("Fecha de nacimiento (DD/MM/AAAA)", color = Color.Gray) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF6200EA),
                    unfocusedBorderColor = Color(0xFF1E1E1E),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            OutlinedTextField(
                value = hora,
                onValueChange = { hora = it },
                label = { Text("Hora exacta (HH:MM)", color = Color.Gray) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF6200EA),
                    unfocusedBorderColor = Color(0xFF1E1E1E),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            OutlinedTextField(
                value = lugar,
                onValueChange = { lugar = it },
                label = { Text("Lugar (Ciudad, País)", color = Color.Gray) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF6200EA),
                    unfocusedBorderColor = Color(0xFF1E1E1E),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { 
                    // Mock data para el MVP
                    chartData = engine.generateAstrologyChart("Leo", "Escorpio", "Acuario") 
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EA)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Calcular Mi Carta", color = Color.White, modifier = Modifier.padding(8.dp))
            }
        } else {
            // Resultados
            val data = chartData!!
            
            AstrologyAspectCard(title = "🌞 Sol (Ego)", sign = data.sol.signo, description = data.sol.descripcion)
            AstrologyAspectCard(title = "🌙 Luna (Emociones)", sign = data.luna.signo, description = data.luna.descripcion)
            AstrologyAspectCard(title = "⬆️ Ascendente (Máscara)", sign = data.ascendente.signo, description = data.ascendente.descripcion)

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF2C2C2C))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Resumen Alquímico", color = Color(0xFF03DAC5), fontWeight = FontWeight.Bold)
                    Text(data.resumen, color = Color.White, fontSize = 14.sp, modifier = Modifier.padding(top = 8.dp))
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            TextButton(onClick = { chartData = null }) {
                Text("Calcular otra vez", color = Color(0xFFBB86FC))
            }
        }
    }
}

@Composable
fun AstrologyAspectCard(title: String, sign: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = title, color = Color(0xFFBB86FC), fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = sign, color = Color(0xFF03DAC5), fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = description, color = Color.LightGray, fontSize = 14.sp, lineHeight = 20.sp)
        }
    }
}