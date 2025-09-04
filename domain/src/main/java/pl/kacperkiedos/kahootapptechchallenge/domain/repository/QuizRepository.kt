package pl.kacperkiedos.kahootapptechchallenge.domain.repository

import pl.kacperkiedos.kahootapptechchallenge.domain.model.Quiz

interface QuizRepository {
    suspend fun getQuiz(quizId: String): Quiz
}
