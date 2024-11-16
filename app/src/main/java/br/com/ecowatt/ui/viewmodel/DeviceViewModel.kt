package br.com.ecowatt.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ecowatt.models.Device
import br.com.ecowatt.repository.DeviceRepository
import kotlinx.coroutines.launch

class DeviceViewModel : ViewModel() {
    private val rtdbUrl = "https://ecowatt-database-default-rtdb.firebaseio.com"
    private val tableName = "devices"
    
    private val repo = DeviceRepository(
        database = rtdbUrl,
        table = tableName
    )
    
    val devices = mutableStateListOf<Device>()

    init {
        loadDevices()
    }

    fun loadDevices() {
        viewModelScope.launch {
            repo.read(
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

    fun newDevice(
        device: Device
    ) {
        viewModelScope.launch {
            repo.create(
                model = device,
                onRequestFailure = {
                    Log.e("ECOWATT", "${it.message}")
                },
                onRequestSuccess = { deviceId ->
                    Log.d("ECOWATT", "Device created! Id: $deviceId")
                    deviceId.let {
                        updateDevice(it, device.copy(id = it))
                        this@DeviceViewModel.loadDevices()
                    }
                }
            )
        }
    }

    fun updateDevice(
        id: String,
        device: Device
    ) {
        viewModelScope.launch {
            repo.update(
                id = id,
                model = device,
                onRequestFailure = {
                    Log.e("ECOWATT", "${it.message}")
                },
                onRequestSuccess = {
                    Log.d("ECOWATT", "Device updated!")
                    this@DeviceViewModel.loadDevices()
                }
            )
        }
    }

    fun deleteDevice(
        id: String
    ) {
        viewModelScope.launch {
            repo.delete(
                id = id,
                onRequestFailure = {
                    Log.e("ECOWATT", "${it.message}")
                },
                onRequestSuccess = {
                    Log.d("ECOWATT", "Device deleted!")
                    this@DeviceViewModel.loadDevices()
                }
            )
        }
    }
}
