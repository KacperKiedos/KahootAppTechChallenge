package pl.kacperkiedos.kahootapptechchallenge.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.Serializable
import pl.kacperkiedos.kahootapptechchallenge.ui.quiz.QuizScreen
import pl.kacperkiedos.kahootapptechchallenge.ui.quiz.QuizScreenEffect
import pl.kacperkiedos.kahootapptechchallenge.ui.quiz.QuizViewModel

@Serializable
data object QuizRoute

internal fun NavController.navigateToQuiz() = navigate(QuizRoute) {
    popBackStack()
}

@SuppressLint("FlowOperatorInvokedInComposition")
internal fun NavGraphBuilder.quiz(navigateToQuizResult: () -> Unit) {
    composable<QuizRoute> {
        val viewModel: QuizViewModel = hiltViewModel()
        val state by viewModel.stateFlow.collectAsStateWithLifecycle()

        val effectFlow: Flow<QuizScreenEffect> = viewModel.effectFlow.flowWithLifecycle(
            lifecycle = LocalLifecycleOwner.current.lifecycle
        )

        QuizScreen(
            state = state,
            onEvent = viewModel::onEvent,
            effectFlow = effectFlow,
            navigateToQuizResult = navigateToQuizResult
        )
    }
}
