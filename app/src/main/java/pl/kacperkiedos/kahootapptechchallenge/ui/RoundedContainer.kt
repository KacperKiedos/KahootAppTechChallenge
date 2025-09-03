package pl.kacperkiedos.kahootapptechchallenge.ui

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
internal fun RoundedContainer(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Card(
        shape = RoundedCornerShape(percent = 50),
        colors = CardDefaults.cardColors().copy(containerColor = Color.White),
        modifier = modifier
    ) {
        content()
    }
}
