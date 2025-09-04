package pl.kacperkiedos.kahootapptechchallenge.ui.header

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import pl.kacperkiedos.kahootapptechchallenge.R
import pl.kacperkiedos.kahootapptechchallenge.ui.quiz.QuestionState

@Composable
internal fun QuestionHeader(
    currentQuestionNumber: Int,
    questionsCount: Int,
    questionState: QuestionState,
    modifier: Modifier = Modifier
) {
    when (questionState) {
        is QuestionState.Displaying -> QuizOngoingHeader(
            currentQuestionNumber = currentQuestionNumber,
            questionsCount = questionsCount,
            modifier = modifier
        )

        is QuestionState.Answered -> QuestionResultHeader(
            headerText = stringResource(
                if (questionState.isAnswerCorrect) {
                    R.string.answer_correct
                } else {
                    R.string.answer_wrong
                }
            ),
            isCorrectAnswerSelected = questionState.isAnswerCorrect,
            modifier = modifier
        )

        else -> QuestionResultHeader(
            headerText = stringResource(R.string.timer_completed),
            isCorrectAnswerSelected = false,
            modifier = modifier
        )
    }
}
