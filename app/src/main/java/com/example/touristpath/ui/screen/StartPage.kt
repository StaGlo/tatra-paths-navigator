import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.touristpath.R
import com.example.touristpath.ui.screen.ui.theme.Purple40

@Composable
fun WelcomePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Witaj w Tatrach!",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            ),
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Text(
            text = "Przeglądaj szlaki turystyczny, mierz swoje czasy przejść, rób zdjęcia i ciesz się pięknem gór!",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        //TODO fix horizontal model for image
        Image(
            painter = painterResource(id = R.drawable.tatry),
            contentDescription = "Tatry",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .border(BorderStroke(5.dp, Purple40))
        )

    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePagePreview() {
    WelcomePage()
}