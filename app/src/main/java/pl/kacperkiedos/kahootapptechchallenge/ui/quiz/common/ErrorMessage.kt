package pl.kacperkiedos.kahootapptechchallenge.ui.quiz.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pl.kacperkiedos.kahootapptechchallenge.R

@Composable
fun ErrorMessage(
    errorMessage: String?,
    onRetryButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 40.dp)
    ) {
        Text(
            text = stringResource(R.string.server_error_title),
            style = MaterialTheme.typography.titleLarge,
        )

        if (errorMessage != null) {
            Text(
                text = stringResource(R.string.server_error_message, errorMessage),
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 12.dp)
            )
        }

        Button(
            onClick = onRetryButtonClick,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = stringResource(R.string.error_retry))
        }
    }
}
