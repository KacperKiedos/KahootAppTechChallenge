package pl.kacperkiedos.kahootapptechchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pl.kacperkiedos.kahootapptechchallenge.ui.answer.RegularAnswersLayout
import pl.kacperkiedos.kahootapptechchallenge.ui.common.KahootButton
import pl.kacperkiedos.kahootapptechchallenge.ui.header.QuizOngoingHeader

@Composable
fun QuizScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        Column {
            QuizOngoingHeader(
                currentQuestionNumber = 2,
                questionsCount = 14,
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
                    model = "https://media.kahoot.it/34b01038-031c-4d23-b8a0-55402916586f_opt",
                    contentDescription = "",
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterHorizontally)
                        .padding(8.dp)
                )

                Question(
                    questionText = "What is the capital of France?",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }

            RegularAnswersLayout(
                onAnswerClick = { },
                modifier = Modifier
                    .weight(30f)
                    .padding(8.dp)
            )

            Footer(
                modifier = Modifier
                    .weight(10f)
                    .fillMaxSize()
            )
        }
    }
}
