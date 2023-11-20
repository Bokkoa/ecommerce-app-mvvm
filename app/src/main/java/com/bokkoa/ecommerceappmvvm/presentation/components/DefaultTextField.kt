package com.bokkoa.ecommerceappmvvm.presentation.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.bokkoa.ecommerceappmvvm.presentation.ui.theme.Blue500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    icon: ImageVector,
    keyBoardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false
) {
    OutlinedTextField(
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyBoardType,
        ),
        modifier = modifier,
        value = value,
        onValueChange = { text: String ->
            onValueChange(text)
        },
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = Blue500,
            )
        },
        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None
//        colors = TextFieldDefaults.textFieldColors(
//            containerColor = Color.White,
//        ),
    )
}
