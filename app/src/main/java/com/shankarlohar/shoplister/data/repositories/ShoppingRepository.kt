package com.shankarlohar.shoplister.data.repositories

import com.shankarlohar.shoplister.data.database.ShoppingDatabase
import com.shankarlohar.shoplister.data.database.entities.ShoppingItem

class ShoppingRepository(
    private val db : ShoppingDatabase
) {

    suspend fun update_or_insert(item: ShoppingItem) = db.getShoppingDao().update_or_insert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun get_all_shopping_items() = db.getShoppingDao().get_all_shopping_items()

}