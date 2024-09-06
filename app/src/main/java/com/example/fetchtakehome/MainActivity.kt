package com.example.fetchtakehome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fetchtakehome.model.Item
import com.example.fetchtakehome.ui.theme.FetchTakeHomeTheme
import com.example.fetchtakehome.viewmodel.FetchViewModel

//Displaying list of items in Composable
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel = FetchViewModel()

        super.onCreate(savedInstanceState)
        setContent {
            FetchTakeHomeTheme {
                var items = viewModel.fetchItems()
                ShowItems(data = items)
                }
            }
        }
    }

//Composable for the entire list
@Composable
fun ShowItems(data: List<Item>) {

    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(data){ item ->
            ItemCard(item)
        }
    }
}

//Composable creating card for each item in list
@Composable
fun ItemCard(item: Item) {

    Card(modifier = Modifier
        .padding(horizontal = 8.dp, vertical = 8.dp)
        .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ){
        Row {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)) {
                Text(text = "ListId: " + item.listId.toString(), style = MaterialTheme.typography.h6)
                Text(text = "ID: " + item.id.toString(), style = MaterialTheme.typography.h6)
                Text(text = "Name: " + item.name, style = MaterialTheme.typography.h6)
            }
        }
    }
}