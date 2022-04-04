package com.stevechou.myexpensetracker.data.category

import androidx.annotation.Keep
import androidx.room.*
import com.stevechou.myexpensetracker.domain.entity.Category

@Dao
@Keep
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg expense: Category)

    @Query("SELECT * FROM category WHERE id = :id")
    fun findCategoryById(id : String) : Category

    @Query("SELECT * FROM category WHERE name != 1")
    fun findCategoryByName(name: String) : List<Category>

    @Delete
    fun delete(category: Category)
}