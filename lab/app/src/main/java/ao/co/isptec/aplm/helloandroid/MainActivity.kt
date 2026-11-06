package ao.co.isptec.aplm.helloandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ao.co.isptec.aplm.helloandroid.ui.theme.HelloAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloAndroidTheme {
                App()
            }
        }
        Log.d("MainActivity", "Aplicacao iniciada com sucesso")
    }

    @Composable
    fun App() {
        val context = LocalContext.current
        var text by remember { mutableStateOf("") }

        Column (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = {text = it},
                label = {Text("Type your message")},
                textStyle = TextStyle(color = Color.Black),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (text.isBlank()) {
                        Toast.makeText(context, "Escreve uma mensagem primeiro.", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.d("MainActivity", "Clicou no botao")
                        val intent = Intent(context, DisplayMessageActivity::class.java).apply {
                            putExtra("EXTRA_MESSAGE", text)
                        }

                        context.startActivity(intent)
                    }
                }
            ) {
                Text("Send")
            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun AppPreview() {
        App()
    }
}
