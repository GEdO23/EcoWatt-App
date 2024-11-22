package br.com.ecowatt.repository

import br.com.ecowatt.dto.auth.LoginRequest
import br.com.ecowatt.dto.auth.LoginResponse
import br.com.ecowatt.dto.auth.SignupRequest
import br.com.ecowatt.dto.auth.SignupResponse
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
        user: SignupRequest,
        onRequestFailure: (e: IOException) -> Unit,
        onRequestSuccess: (signupResponse: SignupResponse) -> Unit
    ) {
        val url = "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=$apiKey"
        val json = gson.toJson(user)
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

                if (response.isSuccessful) {
                    val signupResponse: SignupResponse =
                        gson.fromJson(localBody, SignupResponse::class.java)

                    onRequestSuccess(signupResponse)
                } else {
                    onRequestFailure(IOException("Sign up failed"))
                }
            }
        }

        httpClient.newCall(request)
            .enqueue(response)
    }

    fun login(
        user: LoginRequest,
        onRequestFailure: (e: IOException) -> Unit,
        onRequestSuccess: (loginResponse: LoginResponse) -> Unit
    ) {
        val url =
            "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=$apiKey"
        val json = gson.toJson(user)
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

                if (response.isSuccessful) {
                    val loginResponse: LoginResponse =
                        gson.fromJson(localBody, LoginResponse::class.java)

                    onRequestSuccess(loginResponse)
                } else {
                    onRequestFailure(IOException("Login failed"))
                }
            }
        }

        httpClient.newCall(request)
            .enqueue(response)
    }
}