package br.com.ecowatt.repository

import br.com.ecowatt.models.Device
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class DeviceRepository {
    private val url = "https://ecowatt-database-default-rtdb.firebaseio.com"
    private val gson = Gson()
    private val httpClient = OkHttpClient()

    fun getDevices(
        onRequestFailure: (e: IOException) -> Unit,
        onRequestSuccess: (devices: HashMap<String, Device?>?) -> Unit
    ) {
        val request = Request.Builder()
            .url("$url/devices.json")
            .get()
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                onRequestFailure(e)
            }

            override fun onResponse(call: Call, response: Response) {
                val localBody = response.body?.string() ?: ""

                if (localBody != "" && localBody != "null") {
                    val typeToken = object : TypeToken<HashMap<String, Device?>?>() {}.type
                    val devices: HashMap<String, Device?>? =
                        gson.fromJson(localBody, typeToken)

                    onRequestSuccess(devices)
                }
            }
        }

        httpClient.newCall(request)
            .enqueue(response)
    }

    fun createDevice(
        device: Device,
        onRequestFailure: (e: IOException) -> Unit,
        onRequestSuccess: () -> Unit
    ) {
        val json = gson.toJson(device)
        val body = json.toRequestBody("application/json".toMediaType())

        val request = Request.Builder()
            .url("$url/devices.json")
            .post(body)
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                onRequestFailure(e)
            }

            override fun onResponse(call: Call, response: Response) {
                val localBody = response.body?.string() ?: ""

                if (localBody != "" && localBody != "null") {
                    onRequestSuccess()
                }
            }
        }

        httpClient.newCall(request)
            .enqueue(response)
    }
}