package org.insbaixcamp.imca2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.insbaixcamp.imca2.ui.theme.ImcA2Theme
import kotlin.collections.mutableSetOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImcA2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  BMIscreen()
                }
            }
        }
    }
}


@Composable
fun BMIscreen() {
    var nom: String by remember { mutableStateOf("") }
    var pes: Int by remember { mutableStateOf(80) }
    var alçada: Int by remember { mutableStateOf(value = 100) }
    var bmi: Float by remember {mutableStateOf(value = 0f)}

    Column() {
        Text(text = "Calculadora IMC")
        TextField(
            value = nom,
            onValueChange = { nom = it },
            label = {
                Text(text = "Nom")
            }
        )
        Row() {
            Text(text = "Pes: $pes Kg")
            Button(
                onClick = { pes-- }
            ) {
                Text(text = "-")
            }
            Button(
                onClick = { pes++ }
            ) {
                Text(text = "+")
            }
        }
        Text(text = "Alçada $pes cm")
        Slider(
            value = alçada.toFloat(),
            onValueChange = { alçada = it.toInt() },
            valueRange = 100f..250f,

            )
        Button(onClick = {
            val alçadaMetres = alçada / 100f
            bmi = pes / (alçadaMetres * alçadaMetres)
        }) {

            Text(text = "CalcularIMC")
        }
        if (bmi != 0.0f){
            Text(text = "IMC: $bmi")
        }
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImcA2Theme {
        BMIscreen()
    }
}