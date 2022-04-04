package com.stevechou.myexpensetracker.data.category

import androidx.room.Database
import androidx.room.RoomDatabase

import com.stevechou.myexpensetracker.domain.entity.Category

@Database(entities = [Category::class], version = 1)
abstract class CategoryDatabase : RoomDatabase() {
    abstract fun categoryDao() : CategoryDao
}
