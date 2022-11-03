package com.rave.stresstapper

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rave.stresstapper.ui.theme.StressTapperTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StressTapperTheme {

                val result : Int by mainViewModel.result.collectAsState()
                var value = mainViewModel.result.collectAsState().value.toString()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {


                        TextField(
                            value = value,
                            onValueChange = { value = it },
                            label = { Text("Label") }
                        )
                        Row (modifier = Modifier.padding(horizontal = 25.dp)){
//                        buttonIncrement(viewModel = mainViewModel)
                            buttonIncrement2(
                                increment = mainViewModel::increment,
                                reset = mainViewModel::reset
                            )
                        }
                        }
                    }}
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
    StressTapperTheme {
        buttonIncrement(viewModel = MainViewModel())
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun buttonIncrement(viewModel: MainViewModel){
    var newValue = viewModel.result.collectAsState().value.toString()
    Box{
        Column() {
            TextField(
                value = newValue,
                onValueChange = { newValue   = it },
                label = { Text("Label") }
            )
//            Button(modifier = Modifier.combinedClickable(
//                onClick =  {
//                println("increment button clicked")
//                viewModel.result},
//            onDoubleClick = { viewModel.reset() }),
//                onClick = { viewModel.increment() }) {
//                Text(text = "Increment +", modifier = Modifier
//                    .padding(horizontal = 30.dp, vertical = .8.dp)
//                    .wrapContentWidth(),
//                )
                Image(painter = painterResource(id = R.drawable.ic_baseline_library_add_24)
                    , contentDescription = "",
                    modifier = Modifier.combinedClickable(
                        onClick = {viewModel.increment()},
                        onLongClick = {viewModel.reset()}

                    ))

            }

        }
    }


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun buttonIncrement2(increment: () -> Unit, reset: ()->Unit){
    Box{
        Column() {
            Image(painter = painterResource(id = R.drawable.ic_baseline_library_add_24)
                , contentDescription = "",
                modifier = Modifier.combinedClickable(
                    onClick = {increment()},
                    onLongClick = {reset()}

                ))

        }

    }
}
