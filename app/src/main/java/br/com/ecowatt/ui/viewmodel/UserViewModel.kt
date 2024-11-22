package br.com.ecowatt.ui.viewmodel

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ecowatt.models.User
import br.com.ecowatt.models.emptyUser
import br.com.ecowatt.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val repo = UserRepository()
    private val mainHandler = Handler(Looper.getMainLooper())

    val user: MutableState<User> = mutableStateOf(emptyUser())

    fun signUp(
        filledUser: User,
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ) {
        viewModelScope.launch {
            repo.signUp(
                user = filledUser,
                onRequestFailure = {
                    Log.e("ECOWATT", "AUTH ERROR: ${it.message}")
                    mainHandler.post { onFailure() }
                },
                onRequestSuccess = {
                    user.value = filledUser
                    mainHandler.post { onSuccess() }
                }
            )
        }
    }
}