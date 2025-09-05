package pl.kacperkiedos.kahootapptechchallenge.quiz.widgets.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundCorrect
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundWrongSelected

@Composable
internal fun QuestionResultHeader(
    isCorrectAnswerSelected: Boolean,
    headerText: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier.background(
            color = if (isCorrectAnswerSelected) {
                QuestionBackgroundCorrect
            } else {
                QuestionBackgroundWrongSelected
            }
        )
    ) {
        Text(
            text = headerText,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
