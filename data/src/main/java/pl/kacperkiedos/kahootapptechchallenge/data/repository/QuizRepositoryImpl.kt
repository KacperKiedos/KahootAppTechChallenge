package pl.kacperkiedos.kahootapptechchallenge.data.repository

import pl.kacperkiedos.kahootapptechchallenge.data.remote.QuizService
import pl.kacperkiedos.kahootapptechchallenge.data.model.map
import pl.kacperkiedos.kahootapptechchallenge.domain.model.Quiz
import pl.kacperkiedos.kahootapptechchallenge.domain.repository.QuizRepository
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val quizService: QuizService
) : QuizRepository {

    override suspend fun getQuiz(quizId: String): Quiz = quizService.getQuiz(quizId).map()
}
