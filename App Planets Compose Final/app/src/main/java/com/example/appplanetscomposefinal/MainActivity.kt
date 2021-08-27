package com.example.appplanetscomposefinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.appplanetscomposefinal.models.Planetas
import com.example.appplanetscomposefinal.ui.theme.AppPlanetsComposeFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppPlanetsComposeFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val planetas = listOf<Planetas>()
                    Planetas("Mercurio", "Planeta mais proximo do sol", R.drawable.mercurio)
                    Planetas("Venus", "Segundo planeta", R.drawable.venus)
                    Planetas("Terra", "Planeta mais proximo", R.drawable.terra)
                    Planetas("Marte", "Planeta vermelho", R.drawable.marte)
                    Planetas("Jupter", "Planeta ", R.drawable.jupiter)
                    Planetas("Saturno", "Planeta v", R.drawable.saturno)
                    Planetas("Urano", "Planeta ", R.drawable.urano)
                    Planetas("Netuno", "Planeta ", R.drawable.netuno)

                }
            }
        }
    }
}
