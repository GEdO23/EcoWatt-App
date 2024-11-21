package br.com.ecowatt.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ecowatt.ui.theme.Azure500
import br.com.ecowatt.ui.theme.Neutral1000
import androidx.compose.material3.Button as MaterialDesignButton

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    MaterialDesignButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = Azure500,
            contentColor = Neutral1000
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.5.sp
        )
    }
}

@Preview
@Composable
private fun ButtonPreview() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(16.dp),
        text = "Submit",
        onClick = {}
    )
}