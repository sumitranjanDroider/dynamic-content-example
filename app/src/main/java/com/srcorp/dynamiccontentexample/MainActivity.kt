package com.srcorp.dynamiccontentexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


var namesList:ArrayList<String> = arrayListOf("Sumit ","Saurabh","Beauty","Beauti","Subhrant")



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          MainScreen()
        }
    }
}
@Composable
fun MainScreen(viewModel: MainViewModel= MainViewModel()){
    val newNameStateContent = remember {
        mutableStateOf("")
    }
   Column(modifier = Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.SpaceEvenly,
       horizontalAlignment = Alignment.CenterHorizontally) {
              GreetingMessage(newNameStateContent.value
              ) { newName -> newNameStateContent.value = newName }
   }
}
@Composable
fun GreetingMessage(textFieldValue:String,
                    textFieldUpdate:(newName:String) -> Unit){


    TextField(value =textFieldValue , onValueChange = textFieldUpdate )
    Button(onClick = {  } ) {
        Text(text = textFieldValue)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}