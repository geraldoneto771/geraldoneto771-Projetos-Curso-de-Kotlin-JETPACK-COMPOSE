package com.example.jetpackcompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                   // ExibeTelaVertical()
                    //TelaInicial()
                    TelaInicial2()
                }
            }
        }
    }


}

// Gerenciamento de Estados
@Composable
fun TelaInicial() {

    var meuTexto by remember {
      mutableStateOf("Entre com um valor")
    }

    Column(modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(60.dp))
        OutlinedTextField(value = meuTexto , onValueChange = {
            meuTexto = it
        })
        // renderizando texto
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = meuTexto)

    }
}

@Composable
fun TelaInicial2(){

    var valorA by remember {
        mutableStateOf("")
    }
    var valorB by remember {
        mutableStateOf("")
    }
    var valorResultado by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(label = { Text(text = "Digite o primeiro valor") },
            value = valorA.toString(),
            onValueChange = {
                valorA = it
            })
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(label = { Text(text = "Digite o segundo valor") },
            value = valorB.toString(),
            onValueChange = {
                valorB = it
            })
        Spacer(modifier = Modifier.height(20.dp))
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 60.dp),onClick = {
            var vA = valorA.toDouble()
            var vB = valorB.toDouble()

            var resultado = vA+vB
            valorResultado = resultado.toString()
        }){
            Text(text = "Somar")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text("Resultado: $valorResultado")
    }
}

//////////////////////////////////////////////

/*// Elementos de Rows
@Composable
fun ExibeTelaHorizontal(){

    // Componentes na horizontal
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp),
        Arrangement.Center
    ){
        Text("Olá, mundo!")
        Text(" Aula 01 de compose")
    }

}*/

/*
// Elementos de Columns
@Preview
@Composable
fun ExibeTelaVertical(){

    // Componentes na horizontal
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(all = 20.dp)
        .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
    // Aplicando estilos nos TextVIew
        Text("Jetpack Compose",
            style = TextStyle(color = Color.Blue,
            fontSize = 32.sp, fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
            ),
            modifier = Modifier.padding(bottom = 10.dp))
        Text(" Aula 01 de compose")
        Text("Olá, mundo!")
        Text(" Aula 01 de compose")

        ExibeTelaHorizontal()
    }

}*/

// TUTORIAL DEVELOPER ANDROID
@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name!")
}
@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard("Android")
}