package by.lexshi.flashlight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import by.lexshi.flashlight.ui.theme.FlashLightTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlashLightTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")

                    var option by remember { mutableStateOf(true) }

                    val flashLight = FlashLight()

                    IconButton(
                        content = {
                            androidx.compose.material3.Icon(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = null
                            )
                        },
                        onClick = {
                            flashLight.flash(this, option)
                            option = if (option) !option else true
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FlashLightTheme {
        Greeting("Android")
    }
}