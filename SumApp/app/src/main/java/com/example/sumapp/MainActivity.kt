package com.example.sumapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTextField()
        }
    }
}


fun sum(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber + secondNumber;
}

@Composable
fun MyTextField() {
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),

        ) {
        val firstNumberState = remember { mutableStateOf(TextFieldValue()) }
        val secondNumberState = remember { mutableStateOf(TextFieldValue()) }
        Text(text = "Sum App", fontSize = 25.sp)
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = firstNumberState.value,
            onValueChange = { firstNumberState.value = it },
            label = { Text("First Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = secondNumberState.value,
            onValueChange = { secondNumberState.value = it },
            label = { Text("Second Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp, 0.dp, 10.dp),
            onClick = {
                val sumNumbers = sum(
                    firstNumberState.value.text.toInt(),
                    secondNumberState.value.text.toInt()
                )
                val message =
                    "La suma de ${firstNumberState.value.text} + ${secondNumberState.value.text} = $sumNumbers"
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            }) {
            Text("Sumar", style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold))
        }
    }
}
