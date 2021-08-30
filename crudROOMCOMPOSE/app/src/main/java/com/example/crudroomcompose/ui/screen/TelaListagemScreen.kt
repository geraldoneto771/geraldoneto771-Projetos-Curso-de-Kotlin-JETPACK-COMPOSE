package com.example.crudroomcompose.Listagem

import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.crudroomcompose.data.entities.Cidades


@Composable
fun TelaListagemScreen(
    viewModel: TelaListagemViewModel = hiltViewModel(), navController: NavController
) {

    var cidades = viewModel.cidadesList.observeAsState(listOf())

    LazyColumn() {
        itemsIndexed(cidades.value) { _, item ->
            meuCard(navController = navController, cidade = item)
        }
    }
}

@Composable
fun meuCard(navController: NavController, cidade: Cidades) {

    Card(elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable {
                navController.currentBackStackEntry?.arguments =
                    Bundle().apply {
                        putParcelable("cidade", cidade)
                    }
                navController.navigate("telaExibir")
            }
    ) {
        Column() {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = cidade.nome_cidade.toString(),
                textAlign = TextAlign.Center
            )
        }

    }
}