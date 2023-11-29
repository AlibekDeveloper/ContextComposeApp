package com.example.composecontextmenu

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecontextmenu.ui.theme.ComposeContextMenuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeContextMenuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(
                            listOf(
                                getString(R.string.name_1),
                                getString(R.string.name_2),
                                getString(R.string.name_3),
                                getString(R.string.name_4),
                                getString(R.string.name_5),
                                getString(R.string.name_6)
                            )
                        ) { name ->
                            PersonItem(
                                personName = name,
                                dropDownItems = listOf(
                                    DropDownItem("Item 1"),
                                    DropDownItem("Item 2"),
                                    DropDownItem("Item 3")
                                ),
                                onItemClick = {
                                    Toast.makeText(
                                        applicationContext, it.text,
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            )
                        }
                    }
                }
            }
        }
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
    ComposeContextMenuTheme {
        Greeting("Android")
    }
}