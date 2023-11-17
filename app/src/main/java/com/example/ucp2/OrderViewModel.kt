package com.example.ucp2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.ucp2.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setData(listData: MutableList<String>) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = listData[0],
                NIM = listData[1],
                Konsentrasi = listData[2],
                JudulSkripsi = listData[3],
            )
        }
    }
    fun resetDosen() {
        _stateUI.value = OrderUIState()
    }
    fun setDospem(DosenPilihan: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(dosen = DosenPilihan)
        }
    }
}