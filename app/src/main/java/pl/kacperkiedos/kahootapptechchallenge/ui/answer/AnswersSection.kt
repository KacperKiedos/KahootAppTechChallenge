package pl.kacperkiedos.kahootapptechchallenge.ui.answer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.kacperkiedos.kahootapptechchallenge.domain.model.Choice
import pl.kacperkiedos.kahootapptechchallenge.domain.model.QuestionType
import pl.kacperkiedos.kahootapptechchallenge.ui.quiz.QuestionState

@Composable
internal fun AnswersSection(
    questionType: QuestionType,
    questionState: QuestionState,
    choices: List<Choice>,
    onAnswerClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    if (questionType == QuestionType.TwoAnswers) {
        TrueFalseAnswersLayout(
            questionState = questionState,
            choices = choices,
            onAnswerClick = onAnswerClick,
            modifier = modifier
        )
    } else {
        RegularAnswersLayout(
            questionState = questionState,
            choices = choices,
            onAnswerClick = onAnswerClick,
            modifier = modifier
        )
    }
}
