package ao.co.isptec.aplm.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ao.co.isptec.aplm.tasks.ui.theme.TasksTheme

data class Task(val title: String, val isDone: Boolean = false)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TasksTheme {
                App()
            }
        }
    }

    @Composable
    fun App() {
        val tasks = remember { mutableStateListOf<Task>() }
        var text by remember { mutableStateOf("") }

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it},
                textStyle = TextStyle(color = Color.Black),
                label = {Text("Enter a task")},
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (text.isNotBlank()){
                        tasks.add(Task(title = text))
                        text = ""
                    }
                }
            ) {
                Text(text = "Add Task")
            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn {
                itemsIndexed(tasks) { index, task ->
                    Row (verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = task.isDone,
                            onCheckedChange = {tasks[index] = task.copy(isDone = it)}
                        )

                        Text(
                            text = task.title,
                            modifier = Modifier.padding(8.dp),
                            textDecoration = if (task.isDone) TextDecoration.LineThrough else null
                            )
                    }

                }
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PrevApp(){
        App()
    }
}
