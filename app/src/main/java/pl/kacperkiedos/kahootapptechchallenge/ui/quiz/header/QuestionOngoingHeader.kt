package pl.kacperkiedos.kahootapptechchallenge.ui.quiz.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pl.kacperkiedos.kahootapptechchallenge.R
import pl.kacperkiedos.kahootapptechchallenge.ui.quiz.common.RoundedContainer

@Composable
internal fun QuizOngoingHeader(
    currentQuestionNumber: Int,
    questionsCount: Int,
    modifier: Modifier
) {
    Box(modifier = modifier) {
        RoundedContainer(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                "$currentQuestionNumber/$questionsCount",
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            )
        }

        RoundedContainer(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Row(
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_quiz),
                    contentDescription = ""
                )

                Text(
                    text = stringResource(R.string.quiz),
                    modifier = Modifier.padding(start = 6.dp)
                )
            }

        }
    }
}