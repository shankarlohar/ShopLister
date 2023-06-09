package com.shankarlohar.shoplister.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shankarlohar.shoplister.data.database.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase(){

    abstract fun getShoppingDao(): ShoppingDao

    companion object{

        @Volatile
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: create_database(context).also { instance = it }
        }

        private fun create_database(context: Context) =
             Room.databaseBuilder(
                context.applicationContext,
                ShoppingDatabase::class.java,
                "ShoppingDB.db"
            ).build()

    }

}