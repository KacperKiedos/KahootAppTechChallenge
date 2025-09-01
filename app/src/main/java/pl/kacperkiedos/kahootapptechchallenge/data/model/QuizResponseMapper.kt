package pl.kacperkiedos.kahootapptechchallenge.data.model

import pl.kacperkiedos.kahootapptechchallenge.domain.model.Choice
import pl.kacperkiedos.kahootapptechchallenge.domain.model.Question
import pl.kacperkiedos.kahootapptechchallenge.domain.model.QuestionType
import pl.kacperkiedos.kahootapptechchallenge.domain.model.Quiz

fun QuizResponse.map() = Quiz(
    title = title,
    description = description,
    audienceType = audienceType,
    coverImageUrl = coverImageUrl,
    creatorUsername = creatorUsername,
    questions = questions.mapNotNull { it.map() }
)

fun QuizResponse.QuestionResponse.map(): Question? {
    if (choices == null || (choices.size != 2 && choices.size != 4)) {
        return null
    }

    return Question(
        question = question,
        time = time,
        type = if (choices.size == 2) QuestionType.TwoAnswers else QuestionType.FourAnswers,
        pointsMultiplier = pointsMultiplier,
        imageUrl = imageUrl,
        resourceDescription = imageMetadata?.resourceDescription,
        choices = choices.map { it.map() }
    )
}

fun QuizResponse.ChoiceResponse.map() = Choice(
    answer = answer,
    correct = correct
)
