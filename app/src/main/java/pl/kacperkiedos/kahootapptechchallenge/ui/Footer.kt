package pl.kacperkiedos.kahootapptechchallenge.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pl.kacperkiedos.kahootapptechchallenge.R
import pl.kacperkiedos.kahootapptechchallenge.ui.common.KahootButton

@Composable
internal fun Footer(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        KahootButton(
            text = stringResource(R.string.next_question_button_title),
            onClick = {},
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxHeight()
                .fillMaxWidth(0.5f)
                .padding(vertical = 4.dp)
        )
    }
}
