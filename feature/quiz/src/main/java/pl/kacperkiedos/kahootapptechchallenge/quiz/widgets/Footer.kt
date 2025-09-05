package pl.kacperkiedos.kahootapptechchallenge.quiz.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pl.kacperkiedos.kahootapptechchallenge.quiz.R
import pl.kacperkiedos.kahootapptechchallenge.quiz.screen.QuestionState
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionTimerBackground
import pl.kacperkiedos.kahootapptechchallenge.ui.widgets.KahootButton

@Composable
internal fun Footer(
    questionState: QuestionState,
    onTimerComplete: () -> Unit,
    onNextQuestionButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        if (questionState is QuestionState.Displaying) {
            ShrinkingTimer(
                totalTimeMillis = questionState.timeLimit,
                progressColor = QuestionTimerBackground,
                textStyle = MaterialTheme.typography.labelMedium.copy(color = Color.White),
                onTimerComplete = onTimerComplete,
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            )
        } else {
            KahootButton(
                text = stringResource(R.string.next_question_button_title),
                onClick = onNextQuestionButtonClick,
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f)
                    .padding(vertical = 4.dp)
            )
        }
    }
}
