package pl.kacperkiedos.kahootapptechchallenge.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import pl.kacperkiedos.kahootapptechchallenge.ui.quizresult.QuizResultScreen

@Serializable
data object QuizResultRoute

internal fun NavController.navigateToQuizResult() = navigate(QuizResultRoute) {
    popBackStack()
}

internal fun NavGraphBuilder.quizResult(navigateToQuiz: () -> Unit) {
    composable<QuizResultRoute> {
        QuizResultScreen(navigateToQuiz)
    }
}
