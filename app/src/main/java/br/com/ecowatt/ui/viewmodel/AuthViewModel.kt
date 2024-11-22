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
import br.com.ecowatt.models.user.User
import br.com.ecowatt.repository.AuthRepository
import kotlinx.coroutines.launch

/**
 * ViewModel for handling user authentication.
 */
class AuthViewModel : ViewModel() {
    private val repo = AuthRepository()
    private val mainHandler = Handler(Looper.getMainLooper())

    /**
     * The current authenticated user.
     * Might be null.
     */
    val currentUser: MutableState<User?> = mutableStateOf(null)

    /**
     * Signs up a new user.
     *
     * @param user The sign-up request data.
     * @param onSuccess Callback function to handle successful sign-up.
     * @param onFailure Callback function to handle sign-up failure.
     * @see AuthRepository
     * @see SignupRequest
     * @see SignupResponse
     */
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

    /**
     * Logs in an existing user.
     *
     * @param user The login request data.
     * @param onSuccess Callback function to handle successful login.
     * @param onFailure Callback function to handle login failure.
     * @see AuthRepository
     * @see LoginRequest
     * @see LoginResponse
     */
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