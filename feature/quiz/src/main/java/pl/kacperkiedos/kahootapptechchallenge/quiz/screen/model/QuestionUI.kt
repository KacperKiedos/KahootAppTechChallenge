package pl.kacperkiedos.kahootapptechchallenge.quiz.screen.model

import kotlinx.collections.immutable.ImmutableList
import pl.kacperkiedos.kahootapptechchallenge.domain.model.QuestionType

data class QuestionUI(
    val questionText: String,
    val time: Int,
    val type: QuestionType,
    val imageUrl: String?,
    val choices: ImmutableList<ChoiceUI>,
)

data class ChoiceUI(
    val answer: String,
    val correct: Boolean,
)
