package com.example.relishrhapsody.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_item_table")
class RecipeItem (
    @ColumnInfo(name = "meal_type") var meal_type: String,
    @ColumnInfo(name = "recipe_title") var recipe_title: String,
    @ColumnInfo(name = "number_of_people") var number_of_people: Int,
    @ColumnInfo(name = "difficulty") var difficulty:String,
    @ColumnInfo(name = "ingredients") var ingredients:String,
    @ColumnInfo(name = "preparation_steps") var preparation_steps:String,
    @ColumnInfo(name = "imageId") var imageId: Int,
    @PrimaryKey(autoGenerate = true) var id:Int=0
)
{


}