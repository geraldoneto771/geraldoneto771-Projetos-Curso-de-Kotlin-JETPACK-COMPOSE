package com.example.appplanetscomposefinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appplanetscomposefinal.models.Planetas
import com.example.appplanetscomposefinal.ui.theme.AppPlanetsComposeFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppPlanetsComposeFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    // Lista de planetas
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

                    // Navegação entre telas
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "TelaListagem"){
                        composable("TelaListagem") {TelaInicial(navController, planetas = planetas)}
                        composable("TelaDetalhePlaneta"){
                            val planeta = navController.previousBackStackEntry?.arguments?.getParcelable<Planetas>("planeta")
                            planeta?.let{
                                TelaDetalhes(navController, planeta = it)
                            }

                        }}

                        }
                    
            }
        }
    }

    @Composable
    fun TelaInicial(navController: NavHostController, planetas: List<Planetas>){

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Lista de planetas",
                style = TextStyle(fontWeight = Bold),
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )

        }

        LazyColumn(modifier = Modifier
            .fillMaxHeight()
            .padding(50.dp)
            .fillMaxWidth()){
            itemsIndexed(planetas){
                _, item -> meuCard(navController, item)
            }
        }
    }

    @Composable
    fun meuCard(navController: NavHostController,planeta: Planetas) {

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
                    navController.currentBackStackEntry?.arguments = Bundle().apply {
                        putParcelable("planeta", planeta)
                    }
                    navController.navigate("TelaDetalhePlaneta")
                }
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                Image(
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp),
                    painter = painterResource(id = planeta.Imagem), contentDescription = "")
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp),
                    text = planeta.nome,
                    style = TextStyle(fontWeight = Bold),
                    textAlign = TextAlign.Center
                )

            }

        }
    }
}
