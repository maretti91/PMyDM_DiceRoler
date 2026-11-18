package com.example.diceroler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroler.ui.theme.DiceRolerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {        // Define la interfaz de la aplicación.
            DiceRolerTheme {        // Aplica el tema visual.
                DiceRollerApp()     // Llama a nuestra pantalla principal.
            }
        }
    }
}

@Preview    // Permite visualizar la aplicación.
@Composable     // Define la interfaz principal.
fun DiceRollerApp() {
    DiceWithButtonAndImage(    // Muestra el contenido del dado.
        modifier = Modifier
            .fillMaxSize()      // Ocupa toda la pantalla.
            .wrapContentSize(Alignment.Center)      // Centra el contenido.
    )
}

@Composable     // Función que contendrá el dado y el botón.
fun DiceWithButtonAndImage(
    modifier: Modifier = Modifier) {     // Recibe un modificador opcional.

    // Guarda el resultado y permite actualizar la interfaz.
    var result by remember { mutableStateOf(1) }

    // Selecciona la imagen correspondiente al resultado.
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = modifier,    // Aplica el tamaño y centrado definido
        horizontalAlignment = Alignment.CenterHorizontally    // Centra los elementos horizontalmente.
    ) {
        Image(
            painter = painterResource(imageResource),   // Imagen dinámica.
            contentDescription = result.toString()  // Número del dado.
        )

        Spacer(modifier = Modifier.height(16.dp))   // Separa el dado del botón.

        Button(
            onClick = {
                result = (1..6).random()    // Genera un número entre 1 y 6.
            }
        ) {
            Text(stringResource(R.string.roll))    // Obtiene el texto "Roll".
        }
    }
}