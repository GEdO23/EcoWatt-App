package br.com.ecowatt.ui.screens.user

import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ecowatt.models.User
import br.com.ecowatt.models.emptyUser
import br.com.ecowatt.ui.components.Button

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    user: MutableState<User>,
    onLogin: (user: User) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = user.value.email,
            onValueChange = { user.value = user.value.copy(email = it) },
            label = { Text("Email") }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = user.value.password,
            onValueChange = { user.value = user.value.copy(password = it) },
            label = { Text("Password") }
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            text = "Login",
            onClick = { onLogin(user.value) }
        )
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp),
        user = remember { mutableStateOf(emptyUser()) },
        onLogin = {}
    )
}