package br.com.ecowatt.repository

import br.com.ecowatt.models.User
import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class UserRepository {
    private val gson = Gson()
    private val httpClient = OkHttpClient()

    private val apiKey = "AIzaSyDPN4xpjTmo-eNuJs-4UnItxMGUId4ePwQ"

    fun signUp(
        user: User,
        onRequestFailure: (e: IOException) -> Unit,
        onRequestSuccess: () -> Unit
    ) {
        val url = "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=$apiKey"
        val json = gson.toJson(user.toRequest())
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
                if (response.isSuccessful) {
                    onRequestSuccess()
                } else {
                    onRequestFailure(IOException(response.message))
                }
            }
        }

        httpClient.newCall(request)
            .enqueue(response)
    }
}