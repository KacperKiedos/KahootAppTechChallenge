package pl.kacperkiedos.kahootapptechchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import pl.kacperkiedos.kahootapptechchalenge.navigation.navigateToQuizResult
import pl.kacperkiedos.kahootapptechchalenge.navigation.quizResult
import pl.kacperkiedos.kahootapptechchallenge.quiz.navigation.QuizRoute
import pl.kacperkiedos.kahootapptechchallenge.quiz.navigation.navigateToQuiz
import pl.kacperkiedos.kahootapptechchallenge.quiz.navigation.quiz

@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = QuizRoute,
        modifier = modifier
    ) {
        quiz(navigateToQuizResult = navController::navigateToQuizResult)
        quizResult(navigateToQuiz = navController::navigateToQuiz)
    }
}
