package com.example.crudroomcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crudroomcompose.Listagem.TelaListagemScreen
import com.example.crudroomcompose.data.entities.Cidades
import com.example.crudroomcompose.ui.screen.TelaCadastrarScreen
import com.example.crudroomcompose.ui.screen.TelaDetalhesScreen
import com.example.crudroomcompose.ui.theme.CrudROOMCOMPOSETheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrudROOMCOMPOSETheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "TelaInicial") {
                        composable("TelaInicial") {
                            TelaInicial(navController)
                        }
                        composable("TelaCasdastrar") {
                            TelaCadastrarScreen(navController = navController)
                        }
                        composable("TelaExibir") {
                            val cidade = navController.previousBackStackEntry?.arguments?.getParcelable<Cidades>("cidade")

                            cidade?.let{
                                TelaDetalhesScreen(navController = navController, cidades = it)
                            }

                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TelaInicial(navController: NavHostController) {

    Scaffold(
        content = {
                    TelaListagemScreen(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("telaCadastrar")
            }) {
                Icon(Icons.Filled.Add, contentDescription = "")
            }
        },
        topBar = {
            TopAppBar(title = { Text(text = "APP CRUD") })


        })
}
