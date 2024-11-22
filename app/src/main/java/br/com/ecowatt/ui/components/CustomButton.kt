package br.com.ecowatt.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ecowatt.R

/**
 * A composable function that displays a custom button with specified text and click action.
 *
 * @param modifier A [Modifier] for customizing the layout or behavior of the button.
 * @param text The text to be displayed on the button.
 * @param onClick The callback to be invoked when the button is clicked.
 * @sample br.com.ecowatt.ui.components.Samples.CustomFilledButtonSample
 * @sample br.com.ecowatt.ui.components.Samples.CustomOutlinedButtonSample
 * @sample br.com.ecowatt.ui.components.Samples.CustomTextButtonSample
 * @see Button
 */
@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
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
private fun CustomButtonPreview() {
    CustomButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(16.dp),
        text = stringResource(R.string.btn_submit_text),
        onClick = {}
    )
}