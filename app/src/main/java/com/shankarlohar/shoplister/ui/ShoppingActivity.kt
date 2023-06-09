package com.shankarlohar.shoplister.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.shankarlohar.shoplister.data.database.ShoppingDatabase
import com.shankarlohar.shoplister.data.database.entities.ShoppingItem
import com.shankarlohar.shoplister.data.repositories.ShoppingRepository
import com.shankarlohar.shoplister.ui.theme.ShopListerTheme
import com.shankarlohar.shoplister.ui.viewmodels.ShoppingViewModel
import com.shankarlohar.shoplister.ui.viewmodels.ShoppingViewModelFactory


class ShoppingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShopListerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                    val database = ShoppingDatabase(this)
//                    val repository = ShoppingRepository(database)
//                    val factory = ShoppingViewModelFactory(repository)
//                    val viewModel = ViewModelProvider(this@ShoppingActivity,factory)[ShoppingViewModel::class.java]

                    val shoppingItems = listOf(
                        ShoppingItem("Item 1", 10),
                        ShoppingItem("Item 2", 5),
                        ShoppingItem("Item 3", 3)
                    )

                    ShoppingList(
                        shoppingItems = shoppingItems,
                        onItemUpdate = { /* Implement item update logic */ },
                        onItemDelete = { /* Implement item delete logic */ },
                        onCreateItem = { /* Implement create item logic */ }
                    )



                }
            }
        }
    }
}

@Composable
fun ShoppingList(
    shoppingItems: List<ShoppingItem>,
    onItemUpdate: (ShoppingItem) -> Unit,
    onItemDelete: (ShoppingItem) -> Unit,
    onCreateItem: () -> Unit
) {
    Column {

        LazyColumn {
            items(shoppingItems) { item ->
                ShoppingItemRow(
                    shoppingItem = item,
                    onItemUpdate = onItemUpdate,
                    onItemDelete = onItemDelete
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = onCreateItem,
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Create Item")
            }
        }
    }
}

@Composable
fun ShoppingItemRow(
    shoppingItem: ShoppingItem,
    onItemUpdate: (ShoppingItem) -> Unit,
    onItemDelete: (ShoppingItem) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                Text(text = shoppingItem.name, fontWeight = FontWeight.Bold)
                Text(text = "Amount: ${shoppingItem.amount}")
            }
            Button(
                onClick = { onItemUpdate(shoppingItem) },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text("Update")
            }
            Button(
                onClick = { onItemDelete(shoppingItem) },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text("Delete")
            }
        }
    }
}


@Preview
@Composable
fun ShoppingListPreview() {
    val shoppingItems = listOf(
        ShoppingItem("Item 1", 10),
        ShoppingItem("Item 2", 5),
        ShoppingItem("Item 3", 3)
    )

    ShoppingList(
        shoppingItems = shoppingItems,
        onItemUpdate = { /* Implement item update logic */ },
        onItemDelete = { /* Implement item delete logic */ },
        onCreateItem = { /* Implement create item logic */ }
    )
}