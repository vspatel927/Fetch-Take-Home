package com.example.fetchtakehome.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.fetchtakehome.model.Item
import com.example.fetchtakehome.service.FetchAPIService

//Using viewModel to load in data from JSON and filter + sort
class FetchViewModel: ViewModel(){

    @Composable
    fun fetchItems(): List<Item> {
        var data by remember { mutableStateOf(emptyList<Item>()) }

        LaunchedEffect(Unit) {
            val response = FetchAPIService.fetchApi.getItems()
            data = response.body()!!
        }

        return data.filter { it.name != null && it.name != "" }
            .sortedWith(compareBy({ it.listId }, { it.name }))
    }
}