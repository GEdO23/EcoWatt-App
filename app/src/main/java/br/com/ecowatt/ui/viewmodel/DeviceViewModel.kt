package br.com.ecowatt.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ecowatt.models.Device
import br.com.ecowatt.repository.DeviceRepository
import kotlinx.coroutines.launch

class DeviceViewModel : ViewModel() {
    private val repo = DeviceRepository()
    val devices = mutableStateListOf<Device>()
    
    init {
        loadDevices()
    }

    fun loadDevices() {
        viewModelScope.launch {
            repo.getDevices(
                onRequestFailure = {
                    Log.e("ECOWATT", "${it.message}")
                },
                onRequestSuccess = {
                    devices.clear()
                    it?.forEach { (_, device) ->
                        if (device != null) devices.add(device)
                    }
                }
            )
        }
    }
}
