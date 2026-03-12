package com.jungiantarot.presentation.tarot

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.jungiantarot.domain.engine.EsotericJsonEngine
import com.jungiantarot.domain.model.MajorArcana
import com.jungiantarot.domain.model.TarotReadingData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TarotViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(TarotUiState())
    val uiState: StateFlow<TarotUiState> = _uiState.asStateFlow()

    private val engine = EsotericJsonEngine()

    fun drawCards(count: Int) {
        viewModelScope.launch {
            _uiState.value = TarotUiState(isLoading = true)
            
            // Simular carga / "viendo anuncio"
            delay(1500)
            
            val shuffledDeck = MajorArcana.shuffled()
            val drawnCards = shuffledDeck.take(count)
            
            val readingData = engine.generateTarotReading(count == 3, drawnCards)

            _uiState.value = TarotUiState(
                isLoading = false,
                readingData = readingData
            )
        }
    }
    
    fun reset() {
        _uiState.value = TarotUiState()
    }
}

data class TarotUiState(
    val isLoading: Boolean = false,
    val readingData: TarotReadingData? = null
)