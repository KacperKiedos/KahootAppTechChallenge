package pl.kacperkiedos.kahootapptechchallenge.ui.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pl.kacperkiedos.kahootapptechchallenge.R
import pl.kacperkiedos.kahootapptechchallenge.ui.Footer
import pl.kacperkiedos.kahootapptechchallenge.ui.Question
import pl.kacperkiedos.kahootapptechchallenge.ui.answer.AnswersSection
import pl.kacperkiedos.kahootapptechchallenge.ui.common.ErrorMessage
import pl.kacperkiedos.kahootapptechchallenge.ui.header.QuestionHeader

@Composable
internal fun QuizScreen(
    state: QuizScreenState,
    onEvent: (QuizScreenEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        when (state) {
            QuizScreenState.Loading -> Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }

            is QuizScreenState.Error -> Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                ErrorMessage(
                    errorMessage = state.errorMessage,
                    onRetryButtonClick = {
                        onEvent(QuizScreenEvent.RetryDataFetch)
                    }
                )
            }

            is QuizScreenState.QuizOngoing -> QuizOngoingScreen(
                quizScreenStateData = state,
                onEvent = onEvent,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
internal fun QuizOngoingScreen(
    quizScreenStateData: QuizScreenState.QuizOngoing,
    onEvent: (QuizScreenEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .paint(
                painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            )
    ) {
        QuestionHeader(
            currentQuestionNumber = quizScreenStateData.currentQuestionNumber,
            questionsCount = quizScreenStateData.questionsCount,
            questionState = quizScreenStateData.questionState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(50f)
        ) {
            AsyncImage(
                model = quizScreenStateData.question.imageUrl,
                contentDescription = "",
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )

            Question(
                questionText = AnnotatedString.fromHtml(
                    htmlString = quizScreenStateData.question.questionText
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }

        AnswersSection(
            questionType = quizScreenStateData.question.type,
            questionState = quizScreenStateData.questionState,
            choices = quizScreenStateData.question.choices,
            onAnswerClick = { selectedAnswerIndex ->
                onEvent(QuizScreenEvent.ChooseQuestion(selectedAnswerIndex))
            },
            modifier = Modifier
                .weight(30f)
                .padding(8.dp)
        )

        Footer(
            onNextQuestionButtonClick = {
                onEvent(QuizScreenEvent.NavigateToNextQuestion)
            },
            modifier = Modifier
                .weight(10f)
                .fillMaxSize()
        )
    }
}
