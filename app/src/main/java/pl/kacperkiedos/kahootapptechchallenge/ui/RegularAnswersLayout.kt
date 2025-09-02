package pl.kacperkiedos.kahootapptechchallenge.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.kacperkiedos.kahootapptechchallenge.R
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundBlue
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundGreen
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundRed
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundYellow

@Composable
internal fun RegularAnswersLayout(
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
        ) {
            AnswerItem(
                text = "Item 1",
                backgroundColor = QuestionBackgroundRed,
                questionIconId = R.drawable.ic_triangle_option,
                index = 1,
                answerSide = AnswerSide.Left,
                onAnswerClick = onAnswerClick,
                modifier = Modifier.weight(1f)
            )

            AnswerItem(
                text = "Item 2",
                backgroundColor = QuestionBackgroundBlue,
                questionIconId = R.drawable.ic_diamond_option,
                index = 2,
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
                text = "Item 3",
                backgroundColor = QuestionBackgroundYellow,
                questionIconId = R.drawable.ic_circle_option,
                index = 3,
                answerSide = AnswerSide.Left,
                onAnswerClick = onAnswerClick,
                modifier = Modifier.weight(1f)
            )

            AnswerItem(
                text = "Item 4",
                backgroundColor = QuestionBackgroundGreen,
                questionIconId = R.drawable.ic_square_option,
                index = 4,
                answerSide = AnswerSide.Right,
                onAnswerClick = onAnswerClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
