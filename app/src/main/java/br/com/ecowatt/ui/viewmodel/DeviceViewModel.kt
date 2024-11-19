package br.com.ecowatt.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ecowatt.models.Device
import br.com.ecowatt.repository.DeviceRepository
import kotlinx.coroutines.launch

/**
 * ViewModel class for managing device data and operations.
 *
 * @see Device
 * @see DeviceRepository
 */
class DeviceViewModel : ViewModel() {
    private val rtdbUrl = "https://ecowatt-database-default-rtdb.firebaseio.com"
    private val tableName = "devices"

    private val repo = DeviceRepository(
        database = rtdbUrl,
        table = tableName
    )

    /**
     * A mutable list to hold Device objects.
     *
     * @see Device
     */
    val devices = mutableStateListOf<Device>()

    init {
        loadDevices()
    }

    /**
     * Loads the list of devices from the repository.
     *
     * @see Device
     * @see DeviceRepository
     */
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
                    devices.sortBy { device -> device.name }
                }
            )
        }
    }

    /**
     * Creates a new device in the repository.
     *
     * @param device The device object to be created.
     *
     * @see Device
     * @see DeviceRepository
     */
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

    /**
     * Updates an existing device in the repository.
     *
     * @param id The ID of the device to be updated.
     * @param device The device object with updated data.
     *
     * @see Device
     * @see DeviceRepository
     */
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

    /**
     * Deletes a device from the repository.
     *
     * @param id The ID of the device to be deleted.
     *
     * @see Device
     * @see DeviceRepository
     */
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
                    this@DeviceViewModel.devices.removeAll { it.id == id }
                }
            )
        }
    }
}
