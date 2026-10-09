package org.insbaixcamp.imca2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.imca2.ui.theme.AmberBlack
import org.insbaixcamp.imca2.ui.theme.AmberDark
import org.insbaixcamp.imca2.ui.theme.AmberDim
import org.insbaixcamp.imca2.ui.theme.AmberGold
import org.insbaixcamp.imca2.ui.theme.AmberSurface
import org.insbaixcamp.imca2.ui.theme.ImcA2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImcA2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BMIscreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BMIscreen(modifier: Modifier = Modifier) {
    var nom: String by remember { mutableStateOf("") }
    var pes: Int by remember { mutableIntStateOf(80) }
    var alçada: Int by remember { mutableIntStateOf(170) }
    var bmi: Float by remember { mutableFloatStateOf(0f) }

    val bmiCategory = when {
        bmi == 0f -> ""
        bmi < 18.5f -> "[DIAGNOSTIC: UNDERWEIGHT]"
        bmi < 25f -> "[DIAGNOSTIC: OPTIMAL / NORMAL]"
        bmi < 30f -> "[DIAGNOSTIC: OVERWEIGHT]"
        else -> "[DIAGNOSTIC: HAZARD - OBESE]"
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AmberBlack)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        // Terminal Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, AmberDim)
                .background(AmberSurface)
                .padding(12.dp)
        ) {
            Text(
                text = "> PIP-BOY OS v3000 // TERMINAL ACTIVE",
                color = AmberGold,
                fontFamily = FontFamily.Monospace,
                fontSize = 12.sp
            )
            Text(
                text = "> MODULE: BODY_MASS_ANALYZER",
                color = AmberGold,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        // Subject Name Input
        TextField(
            value = nom,
            onValueChange = { nom = it },
            label = {
                Text(text = "> ENTER_SUBJECT_ID", color = AmberDim, fontFamily = FontFamily.Monospace)
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = AmberSurface,
                unfocusedContainerColor = AmberSurface,
                focusedIndicatorColor = AmberGold,
                unfocusedIndicatorColor = AmberDim,
                focusedTextColor = AmberGold,
                unfocusedTextColor = AmberGold,
                cursorColor = AmberGold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, AmberDim)
        )

        // Weight Controls
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, AmberDim)
                .background(AmberSurface)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "> MASS: [ $pes KG ]",
                color = AmberGold,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { if (pes > 10) pes-- },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AmberDark,
                        contentColor = AmberGold
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .border(1.dp, AmberGold)
                ) {
                    Text(text = "[-] DECREASE", fontFamily = FontFamily.Monospace)
                }
                Button(
                    onClick = { if (pes < 300) pes++ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AmberDark,
                        contentColor = AmberGold
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .border(1.dp, AmberGold)
                ) {
                    Text(text = "[+] INCREASE", fontFamily = FontFamily.Monospace)
                }
            }
        }

        // Height Controls
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, AmberDim)
                .background(AmberSurface)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "> STATURE: [ $alçada CM ]",
                color = AmberGold,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )
            Slider(
                value = alçada.toFloat(),
                onValueChange = { alçada = it.toInt() },
                valueRange = 100f..250f,
                colors = SliderDefaults.colors(
                    thumbColor = AmberGold,
                    activeTrackColor = AmberGold,
                    inactiveTrackColor = AmberDark
                )
            )
        }

        // Execute Button
        Button(
            onClick = {
                val alçadaMetres = alçada / 100f
                if (alçadaMetres > 0f) {
                    bmi = pes / (alçadaMetres * alçadaMetres)
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = AmberDark,
                contentColor = AmberGold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, AmberGold)
        ) {
            Text(
                text = "> COMPUTE_ANALYSIS",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        // Result Output
        if (bmi != 0.0f) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, AmberGold)
                    .background(AmberSurface)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "> SUBJECT: ${if (nom.isBlank()) "VAULT_DWELLER" else nom.uppercase()}",
                    color = AmberGold,
                    fontFamily = FontFamily.Monospace
                )
                Text(
                    text = "> CALCULATED_BMI: %.2f".format(bmi),
                    color = AmberGold,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = bmiCategory,
                    color = AmberGold,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold
                )
            }
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
