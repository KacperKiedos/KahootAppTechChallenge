package pl.kacperkiedos.kahootapptechchalenge.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import pl.kacperkiedos.kahootapptechchalenge.quizresult.QuizResultScreen

@Serializable
data object QuizResultRoute

fun NavController.navigateToQuizResult() = navigate(QuizResultRoute) {
    popBackStack()
}

fun NavGraphBuilder.quizResult(navigateToQuiz: () -> Unit) {
    composable<QuizResultRoute> {
        QuizResultScreen(navigateToQuiz)
    }
}
