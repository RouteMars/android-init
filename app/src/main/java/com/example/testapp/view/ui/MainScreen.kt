package com.example.testapp.view.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testapp.view.theme.TestAppTheme

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting("ddd")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestAppTheme {
        MainScreen()
    }
}