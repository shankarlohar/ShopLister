package com.shankarlohar.shoplister.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.shankarlohar.shoplister.data.database.entities.ShoppingItem
import com.shankarlohar.shoplister.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
): ViewModel() {

    fun update_and_insert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.update_or_insert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun get_all_shopping_items() = repository.get_all_shopping_items()

}