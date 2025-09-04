package pl.kacperkiedos.kahootapptechchallenge.ui.quiz.common

import androidx.compose.ui.graphics.Color

fun Color.darken(darkenBy: Float): Color = copy(
    red = red * darkenBy,
    green = green * darkenBy,
    blue = blue * darkenBy,
    alpha = alpha
)
