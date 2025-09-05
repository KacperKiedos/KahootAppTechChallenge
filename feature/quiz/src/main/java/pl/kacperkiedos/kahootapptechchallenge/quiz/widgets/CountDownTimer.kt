package pl.kacperkiedos.kahootapptechchallenge.quiz.widgets

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import kotlin.math.roundToInt

@Composable
fun ShrinkingTimer(
    totalTimeMillis: Int,
    onTimerComplete: () -> Unit,
    progressColor: Color,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
) {
    val animatedProgress = remember { Animatable(0f) }
    val textMeasurer = rememberTextMeasurer()

    LaunchedEffect(Unit) {
        animatedProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = totalTimeMillis,
                easing = LinearEasing
            )
        )
        onTimerComplete()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .drawWithContent {
                val width = size.width
                val height = size.height
                val cornerRadius = height / 2
                val textMarginRight = 15f

                val remainingTime = (totalTimeMillis - totalTimeMillis * animatedProgress.value).roundToInt() / 1000

                val measuredText = textMeasurer.measure(
                    text = remainingTime.toString(),
                    style = textStyle
                )

                val progressWidth = (width - width * animatedProgress.value).coerceIn(
                    minimumValue = measuredText.size.width + textMarginRight * 2,
                    maximumValue = width
                )

                val textOffsetX = progressWidth - measuredText.size.width - textMarginRight

                val textOffsetY = if (measuredText.size.height < height) {
                    (height - measuredText.size.height) / 2
                } else {
                    0f
                }

                drawRoundRect(
                    color = progressColor,
                    size = Size(progressWidth, height),
                    cornerRadius = CornerRadius(cornerRadius, cornerRadius)
                )

                drawText(
                    measuredText,
                    topLeft = Offset(x = textOffsetX, y = textOffsetY)
                )
            }
    )
}
