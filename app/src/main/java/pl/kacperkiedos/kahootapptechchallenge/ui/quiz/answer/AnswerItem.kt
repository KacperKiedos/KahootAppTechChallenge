package pl.kacperkiedos.kahootapptechchallenge.ui.quiz.answer

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pl.kacperkiedos.kahootapptechchallenge.R
import pl.kacperkiedos.kahootapptechchallenge.domain.model.AnswerState
import pl.kacperkiedos.kahootapptechchallenge.ui.quiz.common.AutoSizeText
import pl.kacperkiedos.kahootapptechchallenge.ui.quiz.common.CustomShadow
import pl.kacperkiedos.kahootapptechchallenge.ui.quiz.common.darken
import pl.kacperkiedos.kahootapptechchallenge.ui.quiz.QuestionState
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundCorrect
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundWrongSelected
import pl.kacperkiedos.kahootapptechchallenge.ui.theme.QuestionBackgroundWrongUnselected

enum class AnswerSide {
    Left,
    Right
}

@Composable
internal fun AnswerItem(
    text: String,
    backgroundColor: Color,
    @DrawableRes questionIconId: Int,
    index: Int,
    answerSide: AnswerSide,
    questionState: QuestionState,
    onAnswerClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxWidth()) {
        val answerState = when (questionState) {
            is QuestionState.Answered -> when {
                questionState.correctAnswerIndex == index -> AnswerState.Correct
                questionState.isAnswerCorrect.not() && questionState.selectedAnswerIndex == index -> AnswerState.IncorrectSelected
                else -> AnswerState.IncorrectUnselected
            }

            is QuestionState.TimerCompleted -> if (questionState.correctAnswerIndex == index) {
                AnswerState.Correct
            } else {
                AnswerState.IncorrectUnselected
            }

            else -> AnswerState.QuizOngoing
        }

        val backgroundColor = when (answerState) {
            AnswerState.QuizOngoing -> backgroundColor
            AnswerState.Correct -> QuestionBackgroundCorrect
            AnswerState.IncorrectSelected -> QuestionBackgroundWrongSelected
            AnswerState.IncorrectUnselected -> QuestionBackgroundWrongUnselected
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .clickable(
                    enabled = questionState is QuestionState.Displaying,
                    onClick = { onAnswerClick(index) }
                )
        ) {
            CustomShadow(
                color = backgroundColor.darken(darkenBy = 0.9f),
                shapeCornerSize = 4.dp,
                modifier = Modifier.fillMaxSize()
            )

            Card(
                shape = RoundedCornerShape(4.dp),
                colors = CardDefaults.cardColors().copy(containerColor = backgroundColor),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 6.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    if (answerState == AnswerState.QuizOngoing) {
                        Icon(
                            painter = painterResource(questionIconId),
                            tint = Color.Unspecified,
                            contentDescription = "",
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(start = 6.dp, top = 8.dp)
                                .height(14.dp)
                        )
                    }

                    AutoSizeText(
                        text = text,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier
                            .padding(start = 28.dp, end = 28.dp, top = 12.dp, bottom = 4.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }

        if (answerState != AnswerState.QuizOngoing) {
            Image(
                painter = painterResource(
                    if (answerState == AnswerState.Correct) {
                        R.drawable.ic_correct_answer
                    } else {
                        R.drawable.ic_wrong_answer
                    }
                ),
                contentDescription = "",
                modifier = Modifier
                    .align(
                        if (answerSide == AnswerSide.Left) Alignment.TopStart
                        else Alignment.TopEnd
                    )
                    .offset(
                        x = if (answerSide == AnswerSide.Left) (-6).dp else 6.dp,
                        y = (-6).dp
                    )
                    .height(30.dp)
            )
        }
    }
}
