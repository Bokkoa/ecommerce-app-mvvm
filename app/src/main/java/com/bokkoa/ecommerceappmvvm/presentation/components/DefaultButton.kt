package com.bokkoa.ecommerceappmvvm.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bokkoa.ecommerceappmvvm.presentation.ui.theme.Blue500
import com.bokkoa.ecommerceappmvvm.presentation.ui.theme.EcommerceAppMVVMTheme
import com.bokkoa.ecommerceappmvvm.presentation.ui.theme.Teal500

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    color: Color = Blue500,
    icon: ImageVector = Icons.Default.ArrowForward,
) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(color),
        modifier = modifier,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultButtonPreview() {
    EcommerceAppMVVMTheme {
        DefaultButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            color = Teal500,
            text = "LOGIN",
            onClick = { /*TODO*/ },
        )
    }
}
