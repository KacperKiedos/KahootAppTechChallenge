package pl.kacperkiedos.kahootapptechchallenge.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.Pink40
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.Purple40
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.PurpleGrey40

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun KahootAppTechChallengeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = KahootAppTechChallengeTypography,
        content = content
    )
}
