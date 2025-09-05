package pl.kacperkiedos.kahootapptechchallenge.quiz.screen.model

import kotlinx.collections.immutable.toImmutableList
import pl.kacperkiedos.kahootapptechchallenge.domain.model.Choice
import pl.kacperkiedos.kahootapptechchallenge.domain.model.Question

internal fun Question.toUI() = QuestionUI(
    questionText = questionText,
    time = time,
    type = type,
    imageUrl = imageUrl,
    choices = choices.map { it.toUI() }.toImmutableList()
)

private fun Choice.toUI() = ChoiceUI(
    answer = answer,
    correct = correct
)
