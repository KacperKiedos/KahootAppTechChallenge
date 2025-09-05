package pl.kacperkiedos.kahootapptechchallenge.quiz.widgets.answer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.ImmutableList
import pl.kacperkiedos.kahootapptechchallenge.domain.model.QuestionType
import pl.kacperkiedos.kahootapptechchallenge.quiz.screen.QuestionState
import pl.kacperkiedos.kahootapptechchallenge.quiz.screen.model.ChoiceUI

@Composable
internal fun AnswersSection(
    questionType: QuestionType,
    questionState: QuestionState,
    choices: ImmutableList<ChoiceUI>,
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
