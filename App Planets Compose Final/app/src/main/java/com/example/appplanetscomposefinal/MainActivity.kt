package com.example.appplanetscomposefinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appplanetscomposefinal.models.Planetas
import com.example.appplanetscomposefinal.ui.theme.AppPlanetsComposeFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppPlanetsComposeFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val planetas = listOf<Planetas>(
                        Planetas("Mercurio", "Planeta mais proximo do sol", R.drawable.mercurio),
                        Planetas("Venus", "Segundo planeta", R.drawable.venus),
                        Planetas("Terra", "Planeta mais proximo", R.drawable.terra),
                        Planetas("Marte", "Planeta vermelho", R.drawable.marte),
                        Planetas("Jupter", "Planeta ", R.drawable.jupiter),
                        Planetas("Saturno", "Planeta v", R.drawable.saturno),
                        Planetas("Urano", "Planeta ", R.drawable.urano),
                        Planetas("Netuno", "Planeta ", R.drawable.netuno)
                    )

                    meuCard(planeta = planetas[2])
                }
            }
        }
    }

    @Composable
    fun meuCard(planeta: Planetas) {

        // Elevation vai de 0 a 8dp, // shape RoundedCornerShape é borda arredondada
        Card(elevation = 4.dp,
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(
                2.dp,
                color = Color(0x77f5f5f5)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .height(120.dp)
                .clickable {

                }
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                Image(painter = painterResource(id = planeta.Imagem), contentDescription = "")
                Text(
                    modifier = Modifier.fillMaxWidth().padding(30.dp),
                    text = planeta.nome,
                    style = TextStyle(fontWeight = Bold),
                    textAlign = TextAlign.Center
                )

            }

        }
    }
}
