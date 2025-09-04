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
) : BaseViewModel<QuizScreenState, QuizScreenEvent>(
    initialState = QuizScreenState.Loading
) {
    private var quizState: QuizState? = null

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

            QuizScreenEvent.NavigateToNextQuestion -> handleNavigationToNextQuestion()

            is QuizScreenEvent.ChooseQuestion -> {
                handleAnswerChoose(event.selectedAnswerIndex)
            }
        }
    }

    private suspend fun fetchQuizData() {
        try {
            val quizData: Quiz = getQuizUseCase(QUIZ_ID)
            val question = quizData.questions[0]

            updateState {
                QuizScreenState.QuizOngoing(
                    currentQuestionNumber = 1,
                    questionsCount = quizData.questions.size,
                    question = question,
                    questionState = QuestionState.Displaying(question.time)
                )
            }

            quizState = QuizState(
                currentQuestionIndex = 0,
                quizData = quizData
            )

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

    private fun handleNavigationToNextQuestion() {
        val state = stateFlow.value
        val quizState = quizState ?: return

        if (state is QuizScreenState.QuizOngoing) {
            updateState {
                val newQuestionIndex = state.currentQuestionNumber + 1
                val newQuestion = quizState.quizData.questions[newQuestionIndex - 1]

                state.copy(
                    currentQuestionNumber = newQuestionIndex,
                    question = newQuestion,
                    questionState = QuestionState.Displaying(timeLimit = newQuestion.time),
                )
            }
        }
    }

    companion object {
        private const val QUIZ_ID = "fb4054fc-6a71-463e-88cd-243876715bc1"
        //private const val QUIZ_ID = "4bc4097d-34a4-4aa5-a4b7-3cf95aa62729"
    }
}

private data class QuizState(
    val currentQuestionIndex: Int,
    val quizData: Quiz
)
