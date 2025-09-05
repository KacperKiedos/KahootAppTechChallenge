package pl.kacperkiedos.kahootapptechchalenge.quizresult

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pl.kacperkiedos.kahootapptechchallenge.quizresult.R
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionTimerBackground
import pl.kacperkiedos.kahootapptechchallenge.ui.widgets.KahootButton

@Composable
internal fun QuizResultScreen(
    navigateToQuiz: () -> Unit
) {
    Box(
        modifier = Modifier.background(QuestionTimerBackground)
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().align(Alignment.Center)
        ) {
            Text(
                text = stringResource(R.string.quiz_completed),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 24.dp)
            )

            KahootButton(
                text = stringResource(R.string.quiz_try_again),
                onClick = navigateToQuiz,
                modifier = Modifier
                    .padding(top = 48.dp)
                    .height(100.dp)
                    .fillMaxWidth(0.75f)
            )
        }
    }
}
