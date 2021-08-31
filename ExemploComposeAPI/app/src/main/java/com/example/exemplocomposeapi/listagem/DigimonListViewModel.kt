package com.example.exemplocomposeapi.listagem

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exemplocomposeapi.Response.DigimonListItem
import com.example.exemplocomposeapi.api.DigimonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DigimonListViewModel @Inject constructor(
    private val repository: DigimonRepository): ViewModel()
{
    var digimonList = mutableStateOf<List<DigimonListItem>>(listOf())

    init {
        loadDigimon()
    }

    fun loadDigimon() {
        viewModelScope.launch {
            digimonList.value = repository.getDigimonList()
        }
    }
}