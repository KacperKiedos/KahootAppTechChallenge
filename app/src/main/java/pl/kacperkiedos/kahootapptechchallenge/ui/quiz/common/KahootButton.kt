package pl.kacperkiedos.kahootapptechchallenge.ui.quiz.common


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
internal fun KahootButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .clickable(onClick = onClick)
    ) {
        CustomShadow(
            color = backgroundColor.darken(darkenBy = 0.9f),
            shapeCornerSize = 4.dp,
            modifier = Modifier.fillMaxSize()
        )

        Card(
            shape = RoundedCornerShape(4.dp),
            colors = CardDefaults.cardColors().copy(containerColor = backgroundColor),
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 6.dp, end = 0.dp, start = 0.dp, top = 0.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.labelLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}
