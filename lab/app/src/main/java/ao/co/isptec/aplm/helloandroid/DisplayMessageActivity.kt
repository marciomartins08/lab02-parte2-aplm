package ao.co.isptec.aplm.helloandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ao.co.isptec.aplm.helloandroid.PalavraBundle.Companion.gerarResumo
import ao.co.isptec.aplm.helloandroid.ui.theme.HelloAndroidTheme

class DisplayMessageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val message = intent.getStringExtra("EXTRA_MESSAGE")


        val palavras = message?.split(" ")?.filter { it.isNotBlank() }
        val bundle = PalavraBundle(palavras)
        val summary = gerarResumo(bundle)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloAndroidTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = message ?: "", fontSize = 24.sp)
                        Text(text = summary, fontSize = 24.sp)
                    }
                }
            }
        }
    }


}

