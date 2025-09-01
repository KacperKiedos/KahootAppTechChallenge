package pl.kacperkiedos.kahootapptechchallenge.data.remote

import pl.kacperkiedos.kahootapptechchallenge.data.model.QuizResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface QuizService {

    @GET("{quizId}")
    suspend fun getQuiz(
        @Path("quizId") quizId: String
    ): QuizResponse
}