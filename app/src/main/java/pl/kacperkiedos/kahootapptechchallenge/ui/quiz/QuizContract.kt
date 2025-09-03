package pl.kacperkiedos.kahootapptechchallenge.ui.quiz

import pl.kacperkiedos.kahootapptechchallenge.domain.model.Question
import pl.kacperkiedos.kahootapptechchallenge.ui.viewmodel.Event
import pl.kacperkiedos.kahootapptechchallenge.ui.viewmodel.State

internal sealed class QuizScreenState : State {
    data object Loading : QuizScreenState()

    data class Error(val errorMessage: String) : QuizScreenState()

    data class QuizOngoing(
        val currentQuestionNumber: Int,
        val questionsCount: Int,
        val question: Question,
        val questionState: QuestionState
    ): QuizScreenState()
}

internal sealed interface QuizScreenEvent : Event {
    data class ChooseQuestion(val selectedAnswerIndex: Int) : QuizScreenEvent

    data object NavigateToNextQuestion : QuizScreenEvent

    data object RetryDataFetch: QuizScreenEvent
}

sealed class QuestionState {
    data object Displaying : QuestionState()

    data class Answered(
        val selectedAnswerIndex: Int,
        val correctAnswerIndex: Int,
        val isAnswerCorrect: Boolean
    ) : QuestionState()
}
