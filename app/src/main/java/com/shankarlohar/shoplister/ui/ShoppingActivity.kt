package com.shankarlohar.shoplister.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.shankarlohar.shoplister.data.database.ShoppingDatabase
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

                    val database = ShoppingDatabase(this)
                    val repository = ShoppingRepository(database)
                    val factory = ShoppingViewModelFactory(repository)
                    val viewModel = ViewModelProvider(this@ShoppingActivity,factory).get(ShoppingViewModel::class.java)

                }
            }
        }
    }
}
