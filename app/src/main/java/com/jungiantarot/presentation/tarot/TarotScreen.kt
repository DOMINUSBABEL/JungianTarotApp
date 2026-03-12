package com.jungiantarot.presentation.tarot

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TarotScreen(
    viewModel: TarotViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (uiState.isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = Color(0xFFBB86FC))
                }
            } else if (uiState.readingData != null) {
                val data = uiState.readingData!!
                
                Text(
                    text = data.tipo_tirada,
                    color = Color(0xFF03DAC5),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                data.cartas.forEach { carta ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = carta.posicion, color = Color(0xFFBB86FC), fontWeight = FontWeight.Bold)
                            Text(text = carta.nombre_carta, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 4.dp))
                            Text(text = carta.significado, color = Color.LightGray, fontSize = 14.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF2C2C2C))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Consejo Final", color = Color(0xFF03DAC5), fontWeight = FontWeight.Bold)
                        Text(data.consejo_final, color = Color.White, fontSize = 14.sp, modifier = Modifier.padding(top = 8.dp))
                    }
                }

                Button(
                    onClick = { viewModel.reset() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EA)),
                    modifier = Modifier.padding(top = 24.dp)
                ) {
                    Text(text = "Nueva Lectura", color = Color.White)
                }

            } else {
                Text(
                    text = "Elige tu Tirada",
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                // Botón Gratis (1 Carta)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF1E1E1E))
                        .clickable { viewModel.drawCards(1) }
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Carta del Día", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text("Gratis", color = Color(0xFF03DAC5), fontSize = 14.sp)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Botón AdMob / Premium (3 Cartas)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF2C2C2C))
                        .clickable { 
                            // Aquí se llamaría a AdMob en producción antes de ejecutar:
                            viewModel.drawCards(3) 
                        }
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Pasado, Presente, Futuro", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text("▶ Ver Anuncio o Ser Premium", color = Color(0xFFBB86FC), fontSize = 14.sp)
                    }
                }
            }
        }
    }
}