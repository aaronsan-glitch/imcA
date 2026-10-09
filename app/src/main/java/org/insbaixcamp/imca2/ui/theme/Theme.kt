package org.insbaixcamp.imca2.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val AmberCRTColorScheme = darkColorScheme(
    primary = AmberGold,
    secondary = AmberDim,
    tertiary = AmberGold,
    background = AmberBlack,
    surface = AmberSurface,
    onPrimary = AmberBlack,
    onSecondary = AmberBlack,
    onTertiary = AmberBlack,
    onBackground = AmberGold,
    onSurface = AmberGold
)

@Composable
fun ImcA2Theme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AmberCRTColorScheme,
        typography = Typography,
        content = content
    )
}
