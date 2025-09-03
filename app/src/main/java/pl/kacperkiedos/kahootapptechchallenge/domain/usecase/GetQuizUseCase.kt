package pl.kacperkiedos.kahootapptechchallenge.domain.usecase

import pl.kacperkiedos.kahootapptechchallenge.domain.model.Quiz
import pl.kacperkiedos.kahootapptechchallenge.domain.repository.QuizRepository

class GetQuizUseCase(
    private val quizRepository: QuizRepository
) {
    suspend operator fun invoke(quizId: String): Quiz {
        return quizRepository.getQuiz(quizId)
    }
}
