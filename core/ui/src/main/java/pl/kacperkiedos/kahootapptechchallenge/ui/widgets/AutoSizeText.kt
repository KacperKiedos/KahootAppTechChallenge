package pl.kacperkiedos.kahootapptechchallenge.ui.widgets

import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun AutoSizeText(
    text: String,
    color: Color,
    style: TextStyle,
    maxFontSize: TextUnit = 14.sp,
    minFontSize: TextUnit = 10.sp,
    textAlign: TextAlign = TextAlign.Unspecified,
    modifier: Modifier = Modifier
) {
    BasicText(
        text = text,
        color = { color },
        autoSize = TextAutoSize.StepBased(maxFontSize = maxFontSize, minFontSize = minFontSize),
        style = style.merge(textAlign = textAlign),
        modifier = modifier
    )
}
