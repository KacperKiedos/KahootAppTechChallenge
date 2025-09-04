package pl.kacperkiedos.kahootapptechchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

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
