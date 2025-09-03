package pl.kacperkiedos.kahootapptechchallenge.ui.header

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.kacperkiedos.kahootapptechchallenge.ui.quiz.QuestionState

@Composable
internal fun QuestionHeader(
    currentQuestionNumber: Int,
    questionsCount: Int,
    questionState: QuestionState,
    modifier: Modifier = Modifier
) {
    when(questionState) {
        is QuestionState.Displaying -> QuizOngoingHeader(
            currentQuestionNumber = currentQuestionNumber,
            questionsCount = questionsCount,
            modifier = modifier
        )

        is QuestionState.Answered -> QuestionResultHeader(
            isCorrectAnswerSelected = questionState.isAnswerCorrect,
            modifier = modifier
        )
    }
}
