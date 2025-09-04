package pl.kacperkiedos.kahootapptechchallenge.ui.quiz.answer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import pl.kacperkiedos.kahootapptechchallenge.R
import pl.kacperkiedos.kahootapptechchallenge.ui.model.ChoiceUI
import pl.kacperkiedos.kahootapptechchallenge.ui.quiz.QuestionState
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundBlue
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundRed

@Composable
internal fun TrueFalseAnswersLayout(
    questionState: QuestionState,
    choices: ImmutableList<ChoiceUI>,
    onAnswerClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp)
        ) {
            AnswerItem(
                text = choices[0].answer,
                backgroundColor = QuestionBackgroundRed,
                questionIconId = R.drawable.ic_triangle_option,
                index = 0,
                questionState = questionState,
                answerSide = AnswerSide.Left,
                onAnswerClick = onAnswerClick,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )

            AnswerItem(
                text = choices[1].answer,
                backgroundColor = QuestionBackgroundBlue,
                questionIconId = R.drawable.ic_diamond_option,
                index = 1,
                questionState = questionState,
                answerSide = AnswerSide.Right,
                onAnswerClick = onAnswerClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

