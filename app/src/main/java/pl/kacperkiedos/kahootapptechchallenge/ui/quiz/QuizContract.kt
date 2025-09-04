package pl.kacperkiedos.kahootapptechchallenge.ui.quiz

import pl.kacperkiedos.kahootapptechchallenge.ui.model.QuestionUI
import pl.kacperkiedos.kahootapptechchallenge.ui.viewmodel.Effect
import pl.kacperkiedos.kahootapptechchallenge.ui.viewmodel.Event
import pl.kacperkiedos.kahootapptechchallenge.ui.viewmodel.State

internal sealed class QuizScreenState : State {
    data object Loading : QuizScreenState()

    data class Error(val errorMessage: String) : QuizScreenState()

    data class QuizOngoing(
        val currentQuestionNumber: Int,
        val questionsCount: Int,
        val question: QuestionUI,
        val questionState: QuestionState
    ) : QuizScreenState()
}

internal sealed interface QuizScreenEvent : Event {
    data class ChooseQuestion(val selectedAnswerIndex: Int) : QuizScreenEvent

    data object NavigateToNextQuestion : QuizScreenEvent

    data object RetryDataFetch : QuizScreenEvent

    data object QuestionTimerCompleted : QuizScreenEvent
}

internal sealed interface QuizScreenEffect: Effect {
    data object NavigateToQuizResult: QuizScreenEffect
}

sealed interface QuestionState {
    data class Displaying(val timeLimit: Int) : QuestionState

    data class TimerCompleted(val correctAnswerIndex: Int) : QuestionState

    data class Answered(
        val selectedAnswerIndex: Int,
        val correctAnswerIndex: Int,
        val isAnswerCorrect: Boolean
    ) : QuestionState
}
