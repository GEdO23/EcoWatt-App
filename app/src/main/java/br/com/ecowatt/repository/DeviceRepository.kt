package br.com.ecowatt.repository

import br.com.ecowatt.models.device.Device
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

/**
 * Repository class for managing device data.
 *
 * @property database The database URL.
 * @property table The table name in the database.
 */
class DeviceRepository(
    private val database: String,
    private val table: String
) : IRepository<String, Device> {
    
    private val gson = Gson()
    private val httpClient = OkHttpClient()
    
    /**
     * Creates a new device in the remote database.
     *
     * @param model The device object to be created.
     * @param onRequestFailure Callback function to handle request failure.
     * @param onRequestSuccess Callback function to handle request success with the created device ID.
     */
    override fun create(
        model: Device,
        onRequestFailure: (e: IOException) -> Unit,
        onRequestSuccess: (id: String) -> Unit
    ) {
        val url = "$database/$table.json"
        
        val json = gson.toJson(model)
        val contentType = "application/json".toMediaType()
        val body = json.toRequestBody(contentType)
        
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                onRequestFailure(e)
            }

            override fun onResponse(call: Call, response: Response) {
                val localBody = response.body?.string() ?: ""

                if (localBody != "" && localBody != "null") {
                    val id = gson.fromJson(localBody, HashMap::class.java)["name"] as String
                    onRequestSuccess(id)
                }
            }
        }

        httpClient.newCall(request)
            .enqueue(response)
    }

    /**
     * Fetches the list of devices from the remote database.
     *
     * @param onRequestFailure Callback function to handle request failure.
     * @param onRequestSuccess Callback function to handle request success with the list of devices.
     */
    override fun read(
        onRequestFailure: (e: IOException) -> Unit,
        onRequestSuccess: (hashMap: HashMap<String, Device?>?) -> Unit
    ) {
        val url = "$database/$table.json"
        
        val request = Request.Builder()
            .url(url)
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

    /**
     * Updates an existing device in the remote database.
     *
     * @param id The ID of the device to be updated.
     * @param model The device object with updated data.
     * @param onRequestFailure Callback function to handle request failure.
     * @param onRequestSuccess Callback function to handle request success.
     */
    override fun update(
        id: String,
        model: Device,
        onRequestFailure: (e: IOException) -> Unit,
        onRequestSuccess: () -> Unit
    ) {
        val url = "$database/$table/$id.json"
        
        val json = gson.toJson(model)
        val contentType = "application/json".toMediaType()
        val body = json.toRequestBody(contentType)
        
        val request = Request.Builder()
            .url(url)
            .put(body)
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                onRequestFailure(e)
            }

            override fun onResponse(call: Call, response: Response) {
                onRequestSuccess()
            }
        }

        httpClient.newCall(request)
            .enqueue(response)
    }

    /**
     * Deletes a device from the remote database.
     *
     * @param id The ID of the device to be deleted.
     * @param onRequestFailure Callback function to handle request failure.
     * @param onRequestSuccess Callback function to handle request success.
     */
    override fun delete(
        id: String,
        onRequestFailure: (e: IOException) -> Unit,
        onRequestSuccess: () -> Unit
    ) {
        val url = "$database/$table/$id.json"
        
        val request = Request.Builder()
            .url(url)
            .delete()
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                onRequestFailure(e)
            }

            override fun onResponse(call: Call, response: Response) {
                onRequestSuccess()
            }
        }

        httpClient.newCall(request)
            .enqueue(response)
    }
}