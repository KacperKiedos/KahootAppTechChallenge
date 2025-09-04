package pl.kacperkiedos.kahootapptechchallenge.ui.quiz.answer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.kacperkiedos.kahootapptechchallenge.R
import pl.kacperkiedos.kahootapptechchallenge.domain.model.Choice
import pl.kacperkiedos.kahootapptechchallenge.ui.quiz.QuestionState
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundBlue
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundGreen
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundRed
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundYellow

@Composable
internal fun RegularAnswersLayout(
    questionState: QuestionState,
    choices: List<Choice>,
    onAnswerClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
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

        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            AnswerItem(
                text = choices[2].answer,
                backgroundColor = QuestionBackgroundYellow,
                questionIconId = R.drawable.ic_circle_option,
                index = 2,
                questionState = questionState,
                answerSide = AnswerSide.Left,
                onAnswerClick = onAnswerClick,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )

            AnswerItem(
                text = choices[3].answer,
                backgroundColor = QuestionBackgroundGreen,
                questionIconId = R.drawable.ic_square_option,
                index = 3,
                questionState = questionState,
                answerSide = AnswerSide.Right,
                onAnswerClick = onAnswerClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
