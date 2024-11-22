package br.com.ecowatt.ui.viewmodel

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ecowatt.dto.auth.LoginRequest
import br.com.ecowatt.dto.auth.LoginResponse
import br.com.ecowatt.dto.auth.SignupRequest
import br.com.ecowatt.dto.auth.SignupResponse
import br.com.ecowatt.models.User
import br.com.ecowatt.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val repo = UserRepository()
    private val mainHandler = Handler(Looper.getMainLooper())

    val currentUser: MutableState<User?> = mutableStateOf(null)

    fun signUp(
        user: SignupRequest,
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ) {
        viewModelScope.launch {
            repo.signUp(
                user = user,
                onRequestFailure = {
                    Log.e("ECOWATT", "AUTH ERROR: ${it.message}")
                    mainHandler.post { onFailure() }
                },
                onRequestSuccess = { resp: SignupResponse ->
                    currentUser.value = resp.toUser()
                    mainHandler.post { onSuccess() }
                }
            )
        }
    }

    fun login(
        user: LoginRequest,
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ) {
        viewModelScope.launch {
            repo.login(
                user = user,
                onRequestFailure = {
                    Log.e("ECOWATT", "AUTH ERROR: ${it.message}")
                    mainHandler.post { onFailure() }
                },
                onRequestSuccess = { resp: LoginResponse ->
                    currentUser.value = resp.toUser()
                    mainHandler.post { onSuccess() }
                }
            )
        }
    }
}