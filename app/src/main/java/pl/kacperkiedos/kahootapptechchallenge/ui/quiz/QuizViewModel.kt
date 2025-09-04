package pl.kacperkiedos.kahootapptechchallenge.ui.quiz

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pl.kacperkiedos.kahootapptechchallenge.domain.model.Quiz
import pl.kacperkiedos.kahootapptechchallenge.domain.usecase.GetQuizUseCase
import pl.kacperkiedos.kahootapptechchallenge.ui.viewmodel.BaseViewModel
import javax.inject.Inject

@HiltViewModel
internal class QuizViewModel @Inject constructor(
    private val getQuizUseCase: GetQuizUseCase
) : BaseViewModel<QuizScreenState, QuizScreenEvent, QuizScreenEffect>(
    initialState = QuizScreenState.Loading
) {
    private var quizData: Quiz? = null

    init {
        viewModelScope.launch {
            fetchQuizData()
        }
    }

    override fun onEvent(event: QuizScreenEvent) {
        when (event) {
            QuizScreenEvent.RetryDataFetch -> viewModelScope.launch {
                fetchQuizData()
            }

            QuizScreenEvent.NavigateToNextQuestion -> viewModelScope.launch {
                handleNavigationToNextQuestion()
            }

            QuizScreenEvent.QuestionTimerCompleted -> handleTimerCompleted()

            is QuizScreenEvent.ChooseQuestion -> {
                handleAnswerChoose(event.selectedAnswerIndex)
            }
        }
    }

    private suspend fun fetchQuizData() {
        try {
            val quizDataResult: Quiz = getQuizUseCase(QUIZ_ID)
            quizData = quizDataResult

            val question = quizDataResult.questions[0]

            updateState {
                QuizScreenState.QuizOngoing(
                    currentQuestionNumber = 1,
                    questionsCount = quizDataResult.questions.size,
                    question = question,
                    questionState = QuestionState.Displaying(question.time)
                )
            }
        } catch (exception: Exception) {
            updateState {
                QuizScreenState.Error(exception.message.toString())
            }
        }
    }

    private fun handleAnswerChoose(answerIndex: Int) {
        val state = stateFlow.value

        if (state is QuizScreenState.QuizOngoing) {
            updateState {
                val correctAnswerIndex = state.question.choices.indexOfFirst { it.correct }

                state.copy(
                    questionState = QuestionState.Answered(
                        selectedAnswerIndex = answerIndex,
                        correctAnswerIndex = correctAnswerIndex,
                        isAnswerCorrect = correctAnswerIndex == answerIndex
                    ),
                )
            }
        }
    }

    private suspend fun handleNavigationToNextQuestion() {
        val state = stateFlow.value
        val quiz = quizData ?: return

        if (state is QuizScreenState.QuizOngoing) {
            if (state.isLastQuestion()) {
                pushEffect(QuizScreenEffect.NavigateToQuizResult)
            } else {
                updateState {
                    val newQuestionIndex = state.currentQuestionNumber + 1
                    val newQuestion = quiz.questions[newQuestionIndex - 1]

                    state.copy(
                        currentQuestionNumber = newQuestionIndex,
                        question = newQuestion,
                        questionState = QuestionState.Displaying(timeLimit = newQuestion.time),
                    )
                }
            }
        }
    }

    private fun handleTimerCompleted() {
        val state = stateFlow.value

        if (state is QuizScreenState.QuizOngoing) {
            val correctAnswerIndex = state.question.choices.indexOfFirst { it.correct }

            updateState {
                state.copy(
                    questionState = QuestionState.TimerCompleted(correctAnswerIndex)
                )
            }
        }
    }

    private fun QuizScreenState.QuizOngoing.isLastQuestion(): Boolean {
        return currentQuestionNumber == questionsCount
    }

    companion object {
        private const val QUIZ_ID = "fb4054fc-6a71-463e-88cd-243876715bc1"
    }
}
