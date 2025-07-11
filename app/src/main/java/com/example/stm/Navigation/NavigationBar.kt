import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Navigationbar(modifier: Modifier = Modifier) {
    var activeIndex by remember { mutableStateOf(0) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth().padding(32.dp)
    ) {
        val icons = listOf(
            Icons.Default.Home,
            Icons.Default.Search,
            Icons.Default.Person,
            Icons.Default.Settings
        )

        icons.forEachIndexed { index, icon ->
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (activeIndex == index) Color.Black else Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .clickable { activeIndex = index }
            )
        }
    }
}
