package com.example.relishrhapsody.ui.explore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.relishrhapsody.R

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        val recipe_title = intent.getStringExtra("recipe_title")
        val meal_type = intent.getStringExtra("meal_type")
        val difficulty = intent.getStringExtra("difficulty")
        val image_id = intent.getIntExtra("image_id", R.drawable.tikka)
        val people_served = intent.getIntExtra("people_served",3)
        val ingredients = intent.getStringExtra("ingredients")
        val prep = intent.getStringExtra("preparation_steps")
        supportActionBar?.title = recipe_title

//        val rTitle: TextView = findViewById(R.id.recipe_title)
        val rImage: ImageView = findViewById(R.id.recipe_image)
        val rIngredients: TextView = findViewById(R.id.ingredients)
        val rPrepSteps: TextView = findViewById(R.id.prep_steps)
        val rRecipeMealType: TextView = findViewById(R.id.recipe_meal)
        val rCookingDifficulty: TextView = findViewById(R.id.cooking_difficulty)

        val rNumberPeopleServed: TextView = findViewById(R.id.number_people_served)

        rPrepSteps.text = prep
        rRecipeMealType.text= meal_type
        rIngredients.text = ingredients
        rCookingDifficulty.text = "Difficulty: "+difficulty
        rNumberPeopleServed.text = people_served.toString()
        rImage.setImageResource(image_id)

    }
}