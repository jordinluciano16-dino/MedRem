package com.example.medrem
// import statements
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.medrem.ui.theme.MedRemTheme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MedRemTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Header
        Text(
            text = "My Medications",
            style = MaterialTheme.typography.headlineLarge
        )

        // Subheader
        Text(
            text = "Today's reminders",
            style = MaterialTheme.typography.titleMedium
        )

        // Regular text
        Text("Button pressed $count times")

        // Buttons
        Button(onClick = { count++ }) {
            Text("Add Medication")
        }

        OutlinedButton(onClick = { count = 0 }) {
            Text("Reset")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MedRemTheme {
        HomeScreen()
    }
}

